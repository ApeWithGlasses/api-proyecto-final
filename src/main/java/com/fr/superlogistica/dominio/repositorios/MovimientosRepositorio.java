package com.fr.superlogistica.dominio.repositorios;

import com.fr.superlogistica.dominio.modelos.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepositorio  extends JpaRepository<Movimientos, Integer> {
}
