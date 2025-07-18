package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.Contrato;
import com.proyecto.soa.entidad.ServicioAdicional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContratoServicioDTO {
    private Long id;
    private Date fechaActivacion;
    private Date fechaDesactivacion;
    private String estado;
    Contrato contrato;
    ServicioAdicional servicioAdicional;
}