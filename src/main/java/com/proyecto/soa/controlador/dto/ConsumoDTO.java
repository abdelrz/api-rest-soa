package com.proyecto.soa.controlador.dto;

import com.proyecto.soa.entidad.Contrato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumoDTO {
    private Long id;
    private BigDecimal gbConsumido;
    private int minutoConsumido;
    private int smsConsumido;
    Contrato contrato;
}