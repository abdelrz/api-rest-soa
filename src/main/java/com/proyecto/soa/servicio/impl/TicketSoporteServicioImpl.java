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

    @Override
    public TicketSoporteDTO aDTO(TicketSoporte ticketSoporte) {
        return TicketSoporteDTO.builder()
                .id(ticketSoporte.getId())
                .asunto(ticketSoporte.getAsunto())
                .descripcion(ticketSoporte.getDescripcion())
                .fechaCreacion(ticketSoporte.getFechaCreacion())
                .estado(ticketSoporte.getEstado())
                .prioridad(ticketSoporte.getPrioridad())
                .cliente(ticketSoporte.getCliente())
                .contrato(ticketSoporte.getContrato())
                .build();
    }

    @Override
    public TicketSoporte desdeDTO(TicketSoporteDTO ticketSoporteDTO) {
        return TicketSoporte.builder()
                .asunto(ticketSoporteDTO.getAsunto())
                .descripcion(ticketSoporteDTO.getDescripcion())
                .fechaCreacion(ticketSoporteDTO.getFechaCreacion())
                .estado(ticketSoporteDTO.getEstado())
                .prioridad(ticketSoporteDTO.getPrioridad())
                .build();
    }
    
    @Override
    public List<TicketSoporteDTO> aDTOList(List<TicketSoporte> ticketssoporte) {
        return ticketssoporte.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarTicketSoporte(TicketSoporteDTO ticketSoporteDTO) throws URISyntaxException {
        if (ticketSoporteDTO.getAsunto().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        TicketSoporte ticketSoporte = desdeDTO(ticketSoporteDTO);
        guardar(ticketSoporte);
        return ResponseEntity.created(new URI("/api/ticketsoporte/guardar")).build();
    }
    
    @Override
    public ResponseEntity<?> actualizarTicketSoporte(Long id, TicketSoporteDTO ticketSoporteDTO) {
        Optional<TicketSoporte> ticketSoporteOptional = encontrarPorId(id);
        if (ticketSoporteOptional.isPresent()) {
            TicketSoporte ticketSoporte = ticketSoporteOptional.get();
            ticketSoporte.setAsunto(ticketSoporteDTO.getAsunto());
            ticketSoporte.setDescripcion(ticketSoporteDTO.getDescripcion());
            ticketSoporte.setFechaCreacion(ticketSoporteDTO.getFechaCreacion());
            ticketSoporte.setEstado(ticketSoporteDTO.getEstado());
            ticketSoporte.setPrioridad(ticketSoporteDTO.getPrioridad());
            guardar(ticketSoporte);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}