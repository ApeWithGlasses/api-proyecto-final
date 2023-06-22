package com.fr.superlogistica.dominio.repositorios;

import com.fr.superlogistica.dominio.modelos.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimientoRepositorio extends JpaRepository<Movimiento, Integer> {
    List<Optional<Movimiento>> findAllByIdMercancia(Integer idMercancia);
}
