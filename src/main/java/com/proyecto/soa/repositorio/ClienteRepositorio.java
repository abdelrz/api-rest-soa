package com.proyecto.soa.repositorio;

import com.proyecto.soa.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
}
