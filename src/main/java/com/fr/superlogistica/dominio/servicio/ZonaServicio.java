package com.fr.superlogistica.dominio.servicio;

import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaRequestDTO;
import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaResponseDTO;
import com.fr.superlogistica.aplicacion.mappers.ZonaMappers.ZonaRequestMapper;
import com.fr.superlogistica.aplicacion.mappers.ZonaMappers.ZonaResponseMapper;
import com.fr.superlogistica.aplicacion.servicio.ServicioBase;
import com.fr.superlogistica.dominio.modelos.Zona;
import com.fr.superlogistica.dominio.repositorios.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicio implements ServicioBase<ZonaRequestDTO, ZonaResponseDTO> {
    @Autowired
    protected ZonaRepositorio zonaRepositorio;

    @Autowired
    protected ZonaRequestMapper requestMapper;

    @Autowired
    protected ZonaResponseMapper responseMapper;

    @Override
    public List<ZonaResponseDTO> obtenerTodos() throws Exception {
        try {
            return responseMapper.mapZonasToZonaResponses(zonaRepositorio.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ZonaResponseDTO obtenerPorId(Integer id) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()) {
                return responseMapper.mapZonaToZonaResponse(zonaOptional.get());
            } else {
                throw new Exception("La zona con la id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ZonaResponseDTO registrar(ZonaRequestDTO datos) throws Exception {
        try {
            return responseMapper.mapZonaToZonaResponse(zonaRepositorio.save(requestMapper.mapZonaRequestToZona(datos)));
        } catch (Exception e) {
            throw new Exception("Por favor verifica todos los campos ingresados.");
        }
    }

    @Override
    public ZonaResponseDTO modificar(Integer id, ZonaRequestDTO nuevosDatos) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()) {
                Zona zonaExistente = zonaOptional.get();
                zonaExistente.setNombre(nuevosDatos.getNombre());
                zonaExistente.setVolumenMaximo(nuevosDatos.getVolumenMaximo());
                return responseMapper.mapZonaToZonaResponse(zonaRepositorio.save(zonaExistente));
            } else {
                throw new Exception("No existe una zona con el id proporcionado.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean eliminar(Integer id) throws Exception {
       try {
           Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
           if (zonaOptional.isPresent()) {
               zonaRepositorio.deleteById(id);
               return true;
           } else {
               throw new Exception("No existe una zona con el id proporcionado.");
           }
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }
}
