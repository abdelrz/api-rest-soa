package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.ContratoServicio;

import java.util.List;
import java.util.Optional;

public interface IContratoServicioDAO {
    List<ContratoServicio> encontrarTodos();
    Optional<ContratoServicio> encontrarPorId(Long id);
    void guardar(ContratoServicio contratoServicio);
    void eliminarPorId(Long id);
}