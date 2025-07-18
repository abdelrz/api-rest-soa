package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.Cliente;
import com.proyecto.soa.entidad.PlanMovil;
import com.proyecto.soa.entidad.Consumo;
import com.proyecto.soa.entidad.ContratoServicio;
import com.proyecto.soa.entidad.Factura;
import com.proyecto.soa.entidad.TicketSoporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContratoDTO {
    private Long id;
    private Date fechaInicio;
    private Date fechaFin;
    private String estadoContrato;
    private String numeroMovil;
    private String operadorAnterior;
    private String cicloFacturacion;
    Cliente cliente;
    PlanMovil planMovil;
    private List<Consumo> consumoList = new ArrayList<>();
    private List<ContratoServicio> contratoServicioList = new ArrayList<>();
    private List<Factura> facturaList = new ArrayList<>();
    private List<TicketSoporte> ticketSoporteList = new ArrayList<>();
}