package org.example.backend.service;

import org.example.backend.dto.VehicleResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class VehicleService {
    private final RestTemplate rest;

    public VehicleService(RestTemplate rest) {
        this.rest = rest;
    }

    public VehicleResponse obtenerDatosVehiculo(String placa) {
        String url =
                "https://srienlinea.sri.gob.ec/sri-matriculacion-vehicular-recaudacion-servicio-internet/"
                        + "rest/BaseVehiculo/obtenerPorNumeroPlacaOPorNumeroCampvOPorNumeroCpn?numeroPlacaCampvCpn=" + placa;

        var raw = rest.getForObject(url, Map.class);
        System.out.println("DEBUG RAW = " + raw);

        VehicleResponse resp = new VehicleResponse();
        resp.setPlaca((String) raw.get("numeroPlaca"));
        resp.setMarca((String) raw.get("descripcionMarca"));
        resp.setModelo((String) raw.get("descripcionModelo"));
        return resp;
    }

}
