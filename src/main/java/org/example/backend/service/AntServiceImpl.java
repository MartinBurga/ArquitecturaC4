package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.AntResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AntServiceImpl implements AntService {

    private final RestTemplate restTemplate;

    private static final String API =
            "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp" +
                    "?ps_tipo_identificacion=CED&ps_identificacion={cedula}&ps_placa=";

    @Override
    @Cacheable(value = "antCache", key = "#cedula")
    public AntResponse obtenerPuntos(String cedula) {

        String html = restTemplate.getForObject(API, String.class, cedula);

        if (html == null || html.length() < 200)
            throw new RuntimeException("ANT no disponible");

        int puntos = extraerPuntos(html);

        return new AntResponse(cedula, puntos);
    }

    private int extraerPuntos(String html) {
        Document doc = Jsoup.parse(html);

        String texto = doc.select("td:contains(Puntos)")
                .first()
                .nextElementSibling()
                .text();

        return Integer.parseInt(texto.trim());
    }
}
