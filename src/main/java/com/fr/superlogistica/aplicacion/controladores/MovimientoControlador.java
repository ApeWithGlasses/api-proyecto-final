package com.fr.superlogistica.aplicacion.controladores;

import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoDTO;
import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoErrorDTO;
import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoRequestDTO;
import com.fr.superlogistica.aplicacion.dto.MovimientoDTOS.MovimientoResponseDTO;
import com.fr.superlogistica.dominio.servicio.MovimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovimientoControlador {
    @Autowired
    protected MovimientoServicio movimientoServicio;

    @GetMapping
    public ResponseEntity<List<MovimientoResponseDTO>> obtenerTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(movimientoServicio.obtenerTodos());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDTO> obtenerPorId(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(movimientoServicio.obtenerPorId(id));
        } catch (Exception e) {
            MovimientoErrorDTO error = new MovimientoErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    @GetMapping("/mercancia/{idMercancia}")
    public ResponseEntity<List<MovimientoResponseDTO>> obtenerPorIdMercancia(@PathVariable(name = "idMercancia") Integer idMercancia) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(movimientoServicio.obtenerPorIdMercancia(idMercancia));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<MovimientoDTO> crearMovimiento(@RequestBody MovimientoRequestDTO movimientoRequestDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(movimientoServicio.registrar(movimientoRequestDTO));
        } catch (Exception e) {
            MovimientoErrorDTO error = new MovimientoErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoDTO> modificar(@RequestBody MovimientoRequestDTO movimientoRequestDTO, @PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(movimientoServicio.modificar(id, movimientoRequestDTO));
        } catch (Exception e) {
            MovimientoErrorDTO error = new MovimientoErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Eliminado correctamente");
        } catch (Exception e) {
            MovimientoErrorDTO error = new MovimientoErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }
}
