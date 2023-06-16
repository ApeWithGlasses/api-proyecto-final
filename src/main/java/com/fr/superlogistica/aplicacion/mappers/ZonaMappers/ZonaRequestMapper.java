package com.fr.superlogistica.aplicacion.mappers.ZonaMappers;

import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaRequestDTO;
import com.fr.superlogistica.dominio.modelos.Zona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ZonaRequestMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "volumenMaximo", target = "volumenMaximo")
    })
    Zona mapZonaRequestToZona(ZonaRequestDTO zonaRequestDTO);
}
