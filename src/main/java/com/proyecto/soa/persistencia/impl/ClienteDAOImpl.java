package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.Cliente;
import com.proyecto.soa.persistencia.IClienteDAO;
import com.proyecto.soa.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ClienteDAOImpl implements IClienteDAO {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Override
    public List<Cliente> encontrarTodos() {
        return (List<Cliente>) clienteRepositorio.findAll();
    }
    @Override
    public Optional<Cliente> encontrarPorId(Long id) {
        return clienteRepositorio.findById(id);
    }
    @Override
    public void guardar(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }
    @Override
    public void eliminarPorId(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
