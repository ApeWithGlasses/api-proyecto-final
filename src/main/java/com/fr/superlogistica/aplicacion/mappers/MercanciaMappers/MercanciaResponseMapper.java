package com.fr.superlogistica.aplicacion.mappers.MercanciaMappers;

import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaResponseDTO;
import com.fr.superlogistica.dominio.modelos.Mercancia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaResponseMapper {
    @Mappings({
        @Mapping(source = "codigoIup", target = "codigoIup"),
            @Mapping(source = "fechaEntrada", target = "fechaEntrada"),
            @Mapping(source = "zona", target = "idZona")
    })
    MercanciaResponseDTO mapMercanciaToMercanciaResponseDTO(Mercancia mercancia);
    List<MercanciaResponseDTO> mapMercanciasToMercanciaResponseDTO(List<Mercancia> mercancias);
}
