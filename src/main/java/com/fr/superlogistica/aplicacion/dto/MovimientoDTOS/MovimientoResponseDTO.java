package com.fr.superlogistica.aplicacion.dto.MovimientoDTOS;

import java.time.LocalDate;

public class MovimientoResponseDTO extends MovimientoDTO {
    private Integer id;
    private String tipoMovimiento;
    private LocalDate fecha;
    private Integer idMercancia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(Integer idMercancia) {
        this.idMercancia = idMercancia;
    }
}
