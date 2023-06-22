package com.fr.superlogistica.aplicacion.mappers.MercanciaMappers;

import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaRequestDTO;
import com.fr.superlogistica.dominio.modelos.Mercancia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MercanciaRequestMapper {
    @Mappings({
            @Mapping(source = "codigoIup", target = "codigoIUP"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "motivoDevolucion", target = "motivoDevolucion"),
            @Mapping(source = "volumen", target = "volumen"),
            @Mapping(source = "enBodega", target = "enBodega"),
            @Mapping(source = "idZona", target = "idZona"),
            @Mapping(target = "fechaEntrada", ignore = true),
            @Mapping(target = "movimientos", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "zona", ignore = true)
    })

    Mercancia mapMercanciaRequestToMercancia(MercanciaRequestDTO mercanciaRequestDTO);
}
