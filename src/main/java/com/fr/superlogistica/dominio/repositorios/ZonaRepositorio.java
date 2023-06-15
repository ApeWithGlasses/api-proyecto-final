package com.fr.superlogistica.dominio.repositorios;

import com.fr.superlogistica.dominio.modelos.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository<Zona, Integer> {

}
