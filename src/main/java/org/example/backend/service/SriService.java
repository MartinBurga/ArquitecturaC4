package org.example.backend.service;

import org.example.backend.dto.SriExistResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SriService {

    private final RestTemplate rest;

    public SriService(RestTemplate rest) {
        this.rest = rest;
    }

    public SriExistResponse existeContribuyente(String ruc) {
        String url = "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/existePorNumeroRuc?numeroRuc=" + ruc;

        Boolean existe = rest.getForObject(url, Boolean.class);
        boolean esContribuyente = existe != null && existe;
        return new SriExistResponse(esContribuyente);
    }
}
