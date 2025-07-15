package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.TicketSoporte;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketSoporteRepositorio extends CrudRepository<TicketSoporte, Long> {
}