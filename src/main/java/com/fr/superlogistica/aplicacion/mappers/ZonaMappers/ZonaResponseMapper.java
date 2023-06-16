package com.fr.superlogistica.aplicacion.mappers.ZonaMappers;

import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaResponseDTO;
import com.fr.superlogistica.dominio.modelos.Zona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ZonaResponseMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "volumenMaximo", target = "volumenMaximo")
    })
    ZonaResponseDTO mapZonaToZonaResponse(Zona zona);
    List<ZonaResponseDTO> mapZonasToZonaResponses(List<Zona> zonas);
}
