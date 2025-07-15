package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.TicketSoporteDTO;
import com.proyecto.soa.entidad.TicketSoporte;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface ITicketSoporteServicio {
    List<TicketSoporte> encontrarTodos();
    Optional<TicketSoporte> encontrarPorId(Long id);
    void guardar(TicketSoporte ticketSoporte);
    void eliminarPorId(Long id);

    TicketSoporteDTO aDTO(TicketSoporte ticketSoporte);
    TicketSoporte desdeDTO(TicketSoporteDTO ticketSoporteDTO);
    List<TicketSoporteDTO> aDTOList(List<TicketSoporte> ticketssoporte);

    ResponseEntity<?> guardarTicketSoporte(TicketSoporteDTO ticketSoporteDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarTicketSoporte(Long id, TicketSoporteDTO ticketSoporteDTO);
}