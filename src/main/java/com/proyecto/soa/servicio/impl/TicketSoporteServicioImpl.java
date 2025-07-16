package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.TicketSoporteDTO;
import com.proyecto.soa.entidad.TicketSoporte;
import com.proyecto.soa.persistencia.ITicketSoporteDAO;
import com.proyecto.soa.servicio.ITicketSoporteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketSoporteServicioImpl implements ITicketSoporteServicio {
    @Autowired
    private ITicketSoporteDAO ticketSoporteDAO;

    @Override
    public List<TicketSoporte> encontrarTodos() {
        return ticketSoporteDAO.encontrarTodos();
    }

    @Override
    public Optional<TicketSoporte> encontrarPorId(Long id) {
        return ticketSoporteDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(TicketSoporte ticketSoporte) {
        ticketSoporteDAO.guardar(ticketSoporte);
    }

    @Override
    public void eliminarPorId(Long id) {
        ticketSoporteDAO.eliminarPorId(id);
    }
}