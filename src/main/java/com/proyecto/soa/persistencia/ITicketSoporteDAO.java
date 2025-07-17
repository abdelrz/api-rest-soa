package com.proyecto.soa.persistencia;

import com.proyecto.soa.entidad.TicketSoporte;

import java.util.List;
import java.util.Optional;

public interface ITicketSoporteDAO {
    List<TicketSoporte> encontrarTodos();
    Optional<TicketSoporte> encontrarPorId(Long id);
    void guardar(TicketSoporte ticketSoporte);
    void eliminarPorId(Long id);
}