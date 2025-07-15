package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.ContratoServicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoServicioRepositorio extends CrudRepository<ContratoServicio, Long> {
}