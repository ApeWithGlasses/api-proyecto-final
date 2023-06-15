package com.fr.superlogistica.aplicacion.dto.MercanciaDTOS;

import java.time.LocalDate;

public class MercanciaRequestDTO extends MercanciaDTO {
    private String codigoIup;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntrada;
    private String motivoDevolucion;
    private Integer volumen;
    private Boolean enBodega;
    private Integer idZona;

    public String getCodigoIup() {
        return codigoIup;
    }

    public void setCodigoIup(String codigoIup) {
        this.codigoIup = codigoIup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Boolean getEnBodega() {
        return enBodega;
    }

    public void setEnBodega(Boolean enBodega) {
        this.enBodega = enBodega;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }
}
