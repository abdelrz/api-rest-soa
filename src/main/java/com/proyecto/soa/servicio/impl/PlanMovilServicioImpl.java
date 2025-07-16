package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.PlanMovilDTO;
import com.proyecto.soa.entidad.PlanMovil;
import com.proyecto.soa.persistencia.IPlanMovilDAO;
import com.proyecto.soa.servicio.IPlanMovilServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanMovilServicioImpl implements IPlanMovilServicio {
    @Autowired
    private IPlanMovilDAO planMovilDAO;

    @Override
    public List<PlanMovil> encontrarTodos() {
        return planMovilDAO.encontrarTodos();
    }

    @Override
    public Optional<PlanMovil> encontrarPorId(Long id) {
        return planMovilDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(PlanMovil planMovil) {
        planMovilDAO.guardar(planMovil);
    }

    @Override
    public void eliminarPorId(Long id) {
        planMovilDAO.eliminarPorId(id);
    }

    @Override
    public PlanMovilDTO aDTO(PlanMovil planMovil) {
        return PlanMovilDTO.builder()
                .id(planMovil.getId())
                .nombre(planMovil.getNombre())
                .descripcion(planMovil.getDescripcion())
                .precioMensual(planMovil.getPrecioMensual())
                .gbDato(planMovil.getGbDato())
                .minutoLlamada(planMovil.getMinutoLlamada())
                .smsIncluido(planMovil.getSmsIncluido())
                .tipoPlan(planMovil.getTipoPlan())
                .contratoList(planMovil.getContratoList())
                .build();
    }

    @Override
    public PlanMovil desdeDTO(PlanMovilDTO planMovilDTO) {
        return PlanMovil.builder()
                .nombre(planMovilDTO.getNombre())
                .descripcion(planMovilDTO.getDescripcion())
                .precioMensual(planMovilDTO.getPrecioMensual())
                .gbDato(planMovilDTO.getGbDato())
                .minutoLlamada(planMovilDTO.getMinutoLlamada())
                .smsIncluido(planMovilDTO.getSmsIncluido())
                .tipoPlan(planMovilDTO.getTipoPlan())
                .build();
    }

    @Override
    public List<PlanMovilDTO> aDTOList(List<PlanMovil> planesmoviles) {
        return planesmoviles.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarPlanMovil(PlanMovilDTO planMovilDTO) throws URISyntaxException {
        if (planMovilDTO.getFechaEmision().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        PlanMovil planMovil = desdeDTO(planMovilDTO);
        guardar(planMovil);
        return ResponseEntity.created(new URI("/api/planmovil/guardar")).build();
    }

    @Override
    public ResponseEntity<?> actualizarPlanMovil(Long id, PlanMovilDTO planMovilDTO) {
        Optional<PlanMovil> planMovilOptional = encontrarPorId(id);
        if (planMovilOptional.isPresent()) {
            PlanMovil planMovil = planMovilOptional.get();
            planMovil.setNombre(facturaDTO.getNombre());
            planMovil.setDescripcion(facturaDTO.getDescripcion());
            planMovil.setPrecioMensual(facturaDTO.getPrecioMensual());
            planMovil.setGbDato(facturaDTO.getGbDato());
            planMovil.setMinutoLlamada(facturaDTO.getMinutoLlamada());
            planMovil.setSmsIncluido(facturaDTO.getSmsIncluido());
            planMovil.setTipoPlan(facturaDTO.getTipoPlan());

            guardar(planMovil);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}