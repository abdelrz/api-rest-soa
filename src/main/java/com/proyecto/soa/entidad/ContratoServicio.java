package com.proyecto.soa.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contrato_servicios")
public class ContratoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_activacion")
    private Date fechaActivacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_desactivacion")
    private Date fechaDesactivacion;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_contrato", nullable = false)
    @JsonIgnore
    Contrato contrato;
    @ManyToOne
    @JoinColumn(name = "id_servicio_adicional", nullable = false)
    @JsonIgnore
    ServicioAdicional servicioAdicional;
}
