package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.Contrato;

import java.util.List;
import java.util.Optional;

public Interface IContratoDAO {
    List<Contrato> encontrarTodos();
    Optional<Contrato> encontrarPorId(Long id);
    void guardar(Contrato contrato);
    void eliminarPorId(Long id);
}