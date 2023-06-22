package com.fr.superlogistica.aplicacion.mappers.MovimientoMappers;

import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoResponseDTO;
import com.fr.superlogistica.dominio.modelos.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoResponseMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "tipoMovimiento", target = "tipoMovimiento"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "idMercancia", target = "idMercancia")
    })

    MovimientoResponseDTO movimientoToMovimientoResponse(Movimiento movimiento);
    List<MovimientoResponseDTO> movimientosToMovimientosResponses(List<Movimiento> movimientos);
}
