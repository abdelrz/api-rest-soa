package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.ServicioAdicional;

import java.util.List;
import java.util.Optional;

public interface IServicioAdicionalDAO {
    List<ServicioAdicional> encontrarTodos();
    Optional<ServicioAdicional> encontrarPorId(Long id);
    void guardar(ServicioAdicional servicioAdicional);
    void eliminarPorId(Long id);
}