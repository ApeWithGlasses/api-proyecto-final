package com.fr.superlogistica.aplicacion.dto.ZonaDTOS;

public class ZonaResponseDTO extends ZonaDTO {
    private Integer id;
    private String nombre;
    private Integer volumenMaximo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
