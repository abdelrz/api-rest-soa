package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.Consumo;

import java.util.List;
import java.util.Optional;

public Interface IConsumoDAO {
    List<Consumo> encontrarTodos();
    Optional<Consumo> encontrarPorId(Long id);
    void guardar(Consumo consumo);
    void eliminarPorId(Long id);
}