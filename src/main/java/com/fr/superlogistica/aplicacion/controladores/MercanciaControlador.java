package com.fr.superlogistica.aplicacion.controladores;

import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaDTO;
import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaErrorDTO;
import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaRequestDTO;
import com.fr.superlogistica.aplicacion.dto.MercanciaDTOS.MercanciaResponseDTO;
import com.fr.superlogistica.dominio.servicio.MercanciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mercancias")
public class MercanciaControlador {
    @Autowired
    protected MercanciaServicio mercanciaServicio;

    @GetMapping
    public ResponseEntity<List<MercanciaResponseDTO>> obtenerTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.obtenerTodos());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MercanciaDTO> obtenerPorId(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.obtenerPorId(id));
        } catch (Exception e) {
            MercanciaErrorDTO error = new MercanciaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    @PostMapping
    public ResponseEntity<MercanciaDTO> crearMercancia(@RequestBody MercanciaRequestDTO mercanciaRequestDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.registrar(mercanciaRequestDTO));
        } catch (Exception e) {
            MercanciaErrorDTO error = new MercanciaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MercanciaDTO> modificar(@PathVariable(name = "id") Integer id, @RequestBody MercanciaRequestDTO mercanciaRequestDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.modificar(id, mercanciaRequestDTO));
        } catch (Exception e) {
            MercanciaErrorDTO error = new MercanciaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable(name = "id") Integer id) {
        try {
            mercanciaServicio.eliminar(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Eliminado correctamente");
        } catch (Exception e) {
            MercanciaErrorDTO error = new MercanciaErrorDTO();
            error.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }
}
