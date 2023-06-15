package com.fr.superlogistica.aplicacion.dto.MercanciaDTOS;

import java.time.LocalDate;

public class MercanciaResponseDTO extends MercanciaDTO {
    private String codigoIup;
    private LocalDate fechaEntrada;
    private Integer idZona;

    public String getCodigoIup() {
        return codigoIup;
    }

    public void setCodigoIup(String codigoIup) {
        this.codigoIup = codigoIup;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }
}
