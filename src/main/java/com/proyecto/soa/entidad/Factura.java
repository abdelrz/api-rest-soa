package com.proyecto.soa.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;
    @Column(name = "monto_total")
    private BigDecimal montoTotal;
    @Column(name = "estado_pago")
    private String estadoPago;
    @Column(name = "metodo_pago")
    private String metodoPago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "numero_factura")
    private String numeroFactura;
    @ManyToOne
    @JoinColumn(name = "id_contrato", nullable = false)
    @JsonIgnore
    Contrato contrato;
}
