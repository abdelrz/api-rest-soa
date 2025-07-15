package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.Consumo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepositorio extends CrudRepository<Consumo, Long> {
}