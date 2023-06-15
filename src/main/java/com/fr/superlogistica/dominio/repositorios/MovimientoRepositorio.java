package com.fr.superlogistica.dominio.repositorios;

import com.fr.superlogistica.dominio.modelos.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepositorio extends JpaRepository<Movimiento, Integer> {
}
