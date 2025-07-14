package com.proyecto.soa.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gb_consumido")
    private BigDecimal gbConsumido;
    @Column(name = "gb_minuto_consumido")
    private int minutoConsumido;
    @Column(name = "sms_consumido")
    private int smsConsumido;
    @ManyToOne
    @JoinColumn(name = "id_contrato", nullable = false)
    @JsonIgnore
    Contrato contrato;
}
