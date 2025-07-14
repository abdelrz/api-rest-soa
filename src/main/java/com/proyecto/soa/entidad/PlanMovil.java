package com.proyecto.soa.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planes_moviles")
public class PlanMovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    @Column(name = "precio_mensual")
    private BigDecimal precioMensual;
    @Column(name = "gb_dato")
    private int gbDato;
    @Column(name = "minuto_llamada")
    private int minutoLlamada;
    @Column(name = "sms_incluido")
    private int smsIncluido;
    @Column(name = "tipo_plan")
    private String tipoPlan;
    @OneToMany(mappedBy = "planMovil", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Contrato> contratoList = new ArrayList<>();
}
