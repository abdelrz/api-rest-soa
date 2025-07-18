package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.Cliente;
import com.proyecto.soa.entidad.Contrato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketSoporteDTO {
    private Long id;
    private String asunto;
    private String descripcion;
    private Date fechaCreacion;
    private String estado;
    private String prioridad;
    Cliente cliente;
    Contrato contrato;
}