package org.example.backend.service;

import org.example.backend.dto.SriPersonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SriInfoService {

    private final RestTemplate rest;

    public SriInfoService(RestTemplate rest) {
        this.rest = rest;
    }

    public SriPersonResponse obtenerInfoContribuyente(String ruc) {
        String url = "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerPorNumerosRuc?ruc=" + ruc;

        SriPersonResponse[] response = rest.getForObject(url, SriPersonResponse[].class);

        if (response != null && response.length > 0) {
            return response[0];
        } else {
            return null;
        }
    }
}
