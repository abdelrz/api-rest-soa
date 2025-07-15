package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.PlanMovil;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMovilRepositorio extends CrudRepository<PlanMovil, Long> {
}