package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.Contrato;
import com.proyecto.soa.entidad.TicketSoporte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;
    private List<Contrato> contratoList = new ArrayList<>();
    private List<TicketSoporte> ticketSoporteList = new ArrayList<>();
}
