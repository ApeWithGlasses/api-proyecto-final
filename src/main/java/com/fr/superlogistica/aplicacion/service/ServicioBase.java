package com.fr.superlogistica.aplicacion.service;

import java.util.List;

public interface ServicioBase<RequestDTO, ResponseDTO> {
    List<ResponseDTO> obtenerTodos() throws Exception;
    ResponseDTO obtenerPorId(Integer id) throws Exception;
    ResponseDTO registrar(RequestDTO datos) throws Exception;
    ResponseDTO modificar(Integer id, RequestDTO nuevosDatos) throws Exception;
    Boolean eliminar(Integer id) throws Exception;
}
