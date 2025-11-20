package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.AntResponse;
import org.example.backend.dto.SriExistResponse;
import org.example.backend.service.AntService;
import org.example.backend.service.SriService;
import org.example.backend.service.VehicleService;
import org.example.backend.dto.VehicleResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final AntService antService;
    private final SriService sriService;
    private final VehicleService vehicleService;

    // -------------------- ANT --------------------
    @GetMapping("/ant/{cedula}")
    public AntResponse getPuntosAnt(@PathVariable String cedula) {
        try {
            return antService.obtenerPuntos(cedula);
        } catch (Exception e) {
            // Manejo de errores para frontend
            throw new RuntimeException("Error consultando ANT: " + e.getMessage());
        }
    }

    // -------------------- SRI --------------------
    @GetMapping("/sri/{ruc}")
    public SriExistResponse getContribuyenteSri(@PathVariable String ruc) {
        try {
            return sriService.existeContribuyente(ruc);
        } catch (Exception e) {
            return new SriExistResponse(false); // En caso de error, devuelve false
        }
    }





    // -------------------- VEHÍCULO --------------------
    @GetMapping("/vehiculo/{placa}")
    public VehicleResponse getDatosVehiculo(@PathVariable String placa) {
        try {
            return vehicleService.obtenerDatosVehiculo(placa);
        } catch (Exception e) {
            throw new RuntimeException("Error consultando vehículo: " + e.getMessage());
        }
    }
}
