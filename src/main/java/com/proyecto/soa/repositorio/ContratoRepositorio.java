package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.Contrato;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepositorio extends CrudRepository<Contrato, Long> {
}