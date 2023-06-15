package com.fr.superlogistica.aplicacion.dto.ZonaDTOS;

public class ZonaRequestDTO extends ZonaDTO{
    private String nombre;
    private Integer volumenMaximo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVolumenMaximo() {
        return volumenMaximo;
    }

    public void setVolumenMaximo(Integer volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }
}
