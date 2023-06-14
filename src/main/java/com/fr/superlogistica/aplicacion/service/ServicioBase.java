package com.fr.superlogistica.aplicacion.service;

import java.util.List;

public interface ServicioBase<E> {
    List<E> obtenerTodos() throws Exception;
    E obtenerPorId(Integer id) throws Exception;
    E registrar(E datos) throws Exception;
    E modificar(Integer id, E nuevosDatos) throws Exception;
    Boolean eliminar(Integer id) throws Exception;
}
