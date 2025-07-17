package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.PlanMovil;

import java.util.List;
import java.util.Optional;

public interface IPlanMovilDAO {
    List<PlanMovil> encontrarTodos();
    Optional<PlanMovil> encontrarPorId(Long id);
    void guardar(PlanMovil planMovil);
    void eliminarPorId(Long id);
}