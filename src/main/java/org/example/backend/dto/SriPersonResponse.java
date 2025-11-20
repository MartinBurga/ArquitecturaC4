package org.example.backend.dto;

public class SriPersonResponse {
    private String numeroRuc;
    private String razonSocial;
    private String estadoContribuyenteRuc;
    private String actividadEconomicaPrincipal;
    private String tipoContribuyente;
    private String fechaInicioActividades;

    public String getNumeroRuc() { return numeroRuc; }
    public void setNumeroRuc(String numeroRuc) { this.numeroRuc = numeroRuc; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getEstadoContribuyenteRuc() { return estadoContribuyenteRuc; }
    public void setEstadoContribuyenteRuc(String estadoContribuyenteRuc) { this.estadoContribuyenteRuc = estadoContribuyenteRuc; }

    public String getActividadEconomicaPrincipal() { return actividadEconomicaPrincipal; }
    public void setActividadEconomicaPrincipal(String actividadEconomicaPrincipal) { this.actividadEconomicaPrincipal = actividadEconomicaPrincipal; }

    public String getTipoContribuyente() { return tipoContribuyente; }
    public void setTipoContribuyente(String tipoContribuyente) { this.tipoContribuyente = tipoContribuyente; }

    public String getFechaInicioActividades() { return fechaInicioActividades; }
    public void setFechaInicioActividades(String fechaInicioActividades) { this.fechaInicioActividades = fechaInicioActividades; }
}
