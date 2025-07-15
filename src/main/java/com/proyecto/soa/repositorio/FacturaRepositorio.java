package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.Factura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends CrudRepository<Factura, Long> {
}