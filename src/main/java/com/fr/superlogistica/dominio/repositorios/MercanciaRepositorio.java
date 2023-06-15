package com.fr.superlogistica.dominio.repositorios;

import com.fr.superlogistica.dominio.modelos.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia, Integer> {
}
