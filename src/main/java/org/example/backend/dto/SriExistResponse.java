package org.example.backend.dto;

public class SriExistResponse {
    private boolean existe;

    public SriExistResponse(boolean b) {
    }

    public boolean isExiste() { return existe; }
    public void setExiste(boolean existe) { this.existe = existe; }
}
