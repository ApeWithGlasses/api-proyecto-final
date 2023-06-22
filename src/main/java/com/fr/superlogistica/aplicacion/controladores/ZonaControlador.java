package com.fr.superlogistica.aplicacion.controladores;

import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaDTO;
import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaErrorDTO;
import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaRequestDTO;
import com.fr.superlogistica.aplicacion.dto.ZonaDTOS.ZonaResponseDTO;
import com.fr.superlogistica.dominio.servicio.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("zonas")
public class ZonaControlador {
    @Autowired
    protected ZonaServicio zonaServicio;

    @GetMapping
    public ResponseEntity<List<ZonaResponseDTO>> obtenerTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.obtenerTodos());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZonaDTO> obtenerPorId(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.obtenerPorId(id));
        } catch (Exception e) {
            ZonaErrorDTO error = new ZonaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    @PostMapping
    public ResponseEntity<ZonaDTO> crearZona(@RequestBody ZonaRequestDTO zonaRequestDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(zonaServicio.registrar(zonaRequestDTO));
        } catch (Exception e) {
            ZonaErrorDTO error = new ZonaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZonaDTO> modificar(@RequestBody ZonaRequestDTO zonaRequestDTO, @PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.modificar(id, zonaRequestDTO));
        } catch (Exception e) {
            ZonaErrorDTO error = new ZonaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable(name = "id") Integer id) {
        try {
            zonaServicio.eliminar(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Eliminado correctamente");
        } catch (Exception e) {
            ZonaErrorDTO error = new ZonaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }
}
