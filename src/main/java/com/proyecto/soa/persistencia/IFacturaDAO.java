package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.Factura;

import java.util.List;
import java.util.Optional;

public Interface IFacturaDAO {
    List<Factura> encontrarTodos();
    Optional<Factura> encontrarPorId(Long id);
    void guardar(Factura factura);
    void eliminarPorId(Long id);
}