package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.PlanMovilDTO;
import com.proyecto.soa.entidad.PlanMovil;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IPlanMovilServicio {
    List<PlanMovil> encontrarTodos();
    Optional<PlanMovil> encontrarPorId(Long id);
    void guardar(PlanMovil planMovil);
    void eliminarPorId(Long id);

    PlanMovilDTO aDTO(PlanMovil planMovil);
    PlanMovil desdeDTO(PlanMovilDTO planMovilDTO);
    List<PlanMovilDTO> aDTOList(List<PlanMovil> planesmoviles);

    ResponseEntity<?> guardarPlanMovil(PlanMovilDTO planMovilDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarPlanMovil(Long id, PlanMovilDTO planMovilDTO);
}