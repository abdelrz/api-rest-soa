package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.Contrato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanMovilDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precioMensual;
    private int gbDato;
    private int minutoLlamada;
    private int smsIncluido;
    private String tipoPlan;
    private List<Contrato> contratoList = new ArrayList<>();
}