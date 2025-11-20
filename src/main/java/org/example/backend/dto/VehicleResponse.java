package org.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class VehicleResponse {

    @JsonAlias({"numeroPlaca"})
    private String placa;

    @JsonAlias({"descripcionMarca"})
    private String marca;

    @JsonAlias({"descripcionModelo"})
    private String modelo;

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
}
