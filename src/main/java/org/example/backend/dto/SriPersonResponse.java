package org.example.backend.dto;

public class SriPersonResponse {
    private String numeroRuc;
    private String nombre;
    private String tipoContribuyente;

    public String getNumeroRuc() {
        return numeroRuc;
    }

    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoContribuyente() {
        return tipoContribuyente;
    }

    public void setTipoContribuyente(String tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }
}

