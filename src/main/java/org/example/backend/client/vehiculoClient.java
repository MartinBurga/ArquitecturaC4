package org.example.backend.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.VehicleResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class vehiculoClient {

    private final RestTemplate restTemplate;

    private static final String ApiVehiculo =
            "https://srienlinea.sri.gob.ec/sri-matriculacion-vehicular-recaudacion-servicio-internet/rest/BaseVehiculo/obtenerPorNumeroPlacaOPorNumeroCampvOPorNumeroCpn?numeroPlacaCampvCpn=";

    public VehicleResponse obtenerVehiculoPorPlaca(String placa) {
        return restTemplate.getForObject(ApiVehiculo + placa, VehicleResponse.class);
    }
}

