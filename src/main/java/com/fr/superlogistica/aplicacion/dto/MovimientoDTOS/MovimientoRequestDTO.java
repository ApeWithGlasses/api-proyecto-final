package com.fr.superlogistica.aplicacion.dto.MovimientoDTOS;

import java.time.LocalDate;

public class MovimientoRequestDTO extends MovimientoDTO {
    private String tipoMovimiento;
    private Integer idMercancia;

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(Integer idMercancia) {
        this.idMercancia = idMercancia;
    }
}
