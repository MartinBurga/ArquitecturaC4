package org.example.backend.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.SriPersonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class sriClient {

    private final RestTemplate restTemplate;

    private static final String ApiExist =
            "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/existePorNumeroRuc?numeroRuc=";

    private static final String ApiData =
            "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerPorNumerosRuc?ruc=";

    public boolean existeContribuyente(String ruc) {
        return restTemplate.getForObject(ApiExist + ruc, Boolean.class);
    }

    public SriPersonResponse obtenerDatosContribuyente(String ruc) {
        return restTemplate.getForObject(ApiData + ruc, SriPersonResponse.class);
    }
}

