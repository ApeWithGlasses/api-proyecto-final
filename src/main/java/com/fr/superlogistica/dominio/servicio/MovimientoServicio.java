package com.fr.superlogistica.dominio.servicio;

import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoRequestDTO;
import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoResponseDTO;
import com.fr.superlogistica.aplicacion.mappers.MovimientoMappers.MovimientoRequestMapper;
import com.fr.superlogistica.aplicacion.mappers.MovimientoMappers.MovimientoResponseMapper;
import com.fr.superlogistica.aplicacion.servicio.ServicioBase;
import com.fr.superlogistica.dominio.modelos.Movimiento;
import com.fr.superlogistica.dominio.repositorios.MovimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoServicio implements ServicioBase<MovimientoRequestDTO, MovimientoResponseDTO> {
    @Autowired
    protected MovimientoRepositorio movimientoRepositorio;

    @Autowired
    protected MovimientoRequestMapper requestMapper;

    @Autowired
    protected MovimientoResponseMapper responseMapper;

    @Override
    public List<MovimientoResponseDTO> obtenerTodos() throws Exception {
        try {
            return responseMapper.movimientosToMovimientosResponses(movimientoRepositorio.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MovimientoResponseDTO obtenerPorId(Integer id) throws Exception {
        try {
            Optional<Movimiento> movimientoOptional = movimientoRepositorio.findById(id);
            if (movimientoOptional.isPresent()) {
                return responseMapper.movimientoToMovimientoResponse(movimientoOptional.get());
            } else {
                throw new Exception("El movimiento con el id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<MovimientoResponseDTO> obtenerPorIdMercancia(Integer idMercancia) throws Exception {
        try {
            List<Optional<Movimiento>> movimientosOptional = movimientoRepositorio.findAllByIdMercancia(idMercancia);
            List<Movimiento> movimientos = new ArrayList<>();

            for (Optional<Movimiento> movimientoOptional : movimientosOptional) {
                movimientoOptional.ifPresent(movimientos::add);
            }

            if (movimientosOptional.isEmpty()) {
                throw new Exception("No se encontraron movimientos relacionados");
            }
            return responseMapper.movimientosToMovimientosResponses(movimientos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MovimientoResponseDTO registrar(MovimientoRequestDTO datos) throws Exception {
        try {
            Movimiento movimientoCreado = requestMapper.movimientoRequestToMovimiento(datos);
            movimientoCreado.setFecha(LocalDate.now());
            return responseMapper.movimientoToMovimientoResponse(movimientoRepositorio.save(movimientoCreado));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MovimientoResponseDTO modificar(Integer id, MovimientoRequestDTO nuevosDatos) throws Exception {
        try {
            Optional<Movimiento> movimientoOptional = movimientoRepositorio.findById(id);
            if (movimientoOptional.isPresent()) {
                Movimiento movimientoExistente = movimientoOptional.get();
                movimientoExistente.setTipoMovimiento(nuevosDatos.getTipoMovimiento());
                movimientoExistente.setFecha(LocalDate.now());
                movimientoExistente.setIdMercancia(nuevosDatos.getIdMercancia());
                return responseMapper.movimientoToMovimientoResponse(movimientoRepositorio.save(movimientoExistente));
            } else {
                throw new Exception("El movimiento con el id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Movimiento> movimientoOptional = movimientoRepositorio.findById(id);
            if (movimientoOptional.isPresent()) {
                movimientoRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("El movimiento con el id " + id + " no existe en la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
