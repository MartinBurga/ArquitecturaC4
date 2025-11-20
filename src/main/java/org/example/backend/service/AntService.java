package org.example.backend.service;

import org.example.backend.dto.AntResponse;

public interface AntService {
    AntResponse obtenerPuntos(String cedula);
}
