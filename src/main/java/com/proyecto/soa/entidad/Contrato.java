package com.proyecto.soa.entidad;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin")
    private Date fechaFin;
    @Column(name = "estado_contrato")
    private String estadoContrato;
    @Column(name = "numero_movil")
    private String numeroMovil;
    @Column(name = "operador_anterior")
    private String operadorAnterior;
    @Column(name = "ciclo_facturacion")
    private String cicloFacturacion;
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonIgnore
    Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_plan_movil", nullable = false)
    @JsonIgnore
    PlanMovil planMovil;
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Consumo> consumoList = new ArrayList<>();
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<ContratoServicio> contratoServicioList = new ArrayList<>();
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Factura> facturaList = new ArrayList<>();
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<TicketSoporte> ticketSoporteList = new ArrayList<>();
}
