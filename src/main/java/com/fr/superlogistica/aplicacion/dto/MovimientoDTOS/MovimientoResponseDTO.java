package com.fr.superlogistica.aplicacion.dto.MovimientoDTOS;

import java.time.LocalDate;

public class MovimientoResponseDTO extends MovimientoDTO {
    private Integer id;
    private String tipoMovimiento;
    private LocalDate fecha;
    private Integer idMercancia;
}
