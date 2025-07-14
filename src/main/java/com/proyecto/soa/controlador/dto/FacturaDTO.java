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
public class FacturaDTO {
    private Long id;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private BigDecimal montoTotal;
    private String estadoPago;
    private String metodoPago;
    private Date fechaPago;
    private String numeroFactura;
    Contrato contrato;
}