package com.fr.superlogistica.dominio.servicio;

import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaRequestDTO;
import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaResponseDTO;
import com.fr.superlogistica.aplicacion.mappers.MercanciaMappers.MercanciaRequestMapper;
import com.fr.superlogistica.aplicacion.mappers.MercanciaMappers.MercanciaResponseMapper;
import com.fr.superlogistica.aplicacion.servicio.ServicioBase;
import com.fr.superlogistica.dominio.modelos.Mercancia;
import com.fr.superlogistica.dominio.repositorios.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio implements ServicioBase<MercanciaRequestDTO, MercanciaResponseDTO> {
    @Autowired
    protected MercanciaRepositorio mercanciaRepositorio;

    @Autowired
    protected MercanciaRequestMapper requestMapper;

    @Autowired
    protected MercanciaResponseMapper responseMapper;


    @Override
    public List<MercanciaResponseDTO> obtenerTodos() throws Exception {
        try {
            return responseMapper.mapMercanciasToMercanciaResponse(mercanciaRepositorio.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MercanciaResponseDTO obtenerPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()) {
                return responseMapper.mapMercanciaToMercanciaResponse(mercanciaOptional.get());
            } else {
                throw new Exception("La mercancia con el id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MercanciaResponseDTO registrar(MercanciaRequestDTO datos) throws Exception {
        try {
            Mercancia mapeoMercancia = requestMapper.mapMercanciaRequestToMercancia(datos);
            mapeoMercancia.setFechaEntrada(LocalDate.now());
            return responseMapper.mapMercanciaToMercanciaResponse(mercanciaRepositorio.save(mapeoMercancia));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MercanciaResponseDTO modificar(Integer id, MercanciaRequestDTO nuevosDatos) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()) {
                Mercancia mercanciaExistente = mercanciaOptional.get();
                mercanciaExistente.setCodigoIUP(nuevosDatos.getCodigoIup());
                mercanciaExistente.setDescripcion(nuevosDatos.getDescripcion());
                mercanciaExistente.setNombre(nuevosDatos.getNombre());
                mercanciaExistente.setEnBodega(nuevosDatos.getEnBodega());
                mercanciaExistente.setMotivoDevolucion(nuevosDatos.getMotivoDevolucion());
                mercanciaExistente.setVolumen(nuevosDatos.getVolumen());
                return responseMapper.mapMercanciaToMercanciaResponse(mercanciaRepositorio.save(mercanciaExistente));
            } else {
                throw new Exception("La mercancia con el id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()) {
                mercanciaRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("La mercancia con el id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
