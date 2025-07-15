package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.TicketSoporte;
import com.proyecto.soa.persistencia.ITicketSoporteDAO;
import com.proyecto.soa.repositorio.TicketSoporteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TicketSoporteDAOImpl implements ITicketSoporteDAO {

    @Autowired
    private TicketSoporteRepositorio ticketSoporteRepositorio;
    
    @Override
    public List<TicketSoporte> encontrarTodos() {
        return (List<TicketSoporte>) ticketSoporteRepositorio.findAll();
    }
    
    @Override
    public Optional<TicketSoporte> encontrarPorId(Long id) {
        return ticketSoporteRepositorio.findById(id);
    }
    
    @Override
    public void guardar(TicketSoporte ticketSoporte) {
        ticketSoporteRepositorio.save(ticketSoporte);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        ticketSoporteRepositorio.deleteById(id);
    }
}