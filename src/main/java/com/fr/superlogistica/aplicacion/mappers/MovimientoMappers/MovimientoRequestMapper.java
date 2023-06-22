package com.fr.superlogistica.aplicacion.mappers.MovimientoMappers;

import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoRequestDTO;
import com.fr.superlogistica.dominio.modelos.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MovimientoRequestMapper {
    @Mappings({
            @Mapping(source = "tipoMovimiento", target = "tipoMovimiento"),
            @Mapping(source = "idMercancia", target = "idMercancia"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "fecha", ignore = true),
            @Mapping(target = "mercancias", ignore = true)
    })
    Movimiento movimientoRequestToMovimiento(MovimientoRequestDTO movimientoRequestDTO);
}
