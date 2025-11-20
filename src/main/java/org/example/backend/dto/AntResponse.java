package org.example.backend.dto;

public class AntResponse {
    private String cedula;
    private int puntos;

    public AntResponse(String cedula, int puntos) {
        this.cedula = cedula;
        this.puntos = puntos;
    }

    public String getCedula() {
        return cedula;
    }

    public int getPuntos() {
        return puntos;
    }
}
