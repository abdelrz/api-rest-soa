package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.ContratoServicio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicioAdicionalDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String tipoServicio;
    private List<ContratoServicio> contratoServicioList = new ArrayList<>();
}