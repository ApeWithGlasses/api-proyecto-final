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
            @Mapping(source = "fechaEntrada", target = "fechaEntrada"),
            @Mapping(source = "motivoDevolucion", target = "motivoDevolucion"),
            @Mapping(source = "volumen", target = "volumen"),
            @Mapping(source = "enBodega", target = "enBodega"),
            @Mapping(source = "idZona", target = "zona.id")
    })

    Mercancia mapMercanciaRequestToMercancia(MercanciaRequestDTO mercanciaRequestDTO);
}
