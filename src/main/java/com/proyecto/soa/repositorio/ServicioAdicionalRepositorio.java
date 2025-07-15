package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.ServicioAdicional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioAdicionalRepositorio extends CrudRepository<ServicioAdicional, Long> {
}