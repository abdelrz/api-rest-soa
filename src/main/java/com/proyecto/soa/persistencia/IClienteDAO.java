package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDAO {
    List<Cliente> encontrarTodos();
    Optional<Cliente> encontrarPorId(Long id);
    void guardar(Cliente cliente);
    void eliminarPorId(Long id);
}
