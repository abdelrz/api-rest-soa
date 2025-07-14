package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.PlanMovilDTO;
import com.proyecto.soa.entidad.PlanMovil;
import com.proyecto.soa.servicio.IPlanMovilServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planmovil")
public class PlanMovilControlador {
    
    @Autowired
    private IPlanMovilServicio planMovilServicio;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<PlanMovil> planMovilOptional = planMovilServicio.encontrarPorId(id);

        if (planMovilOptional.isPresent()) {
            PlanMovilDTO planMovilDTO = planMovilServicio.aDTO(planMovilOptional.get());
            return ResponseEntity.ok(planMovilDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<PlanMovilDTO> planMovilDTOList = planMovilServicio.aDTOList(planMovilServicio.encontrarTodos());
        return ResponseEntity.ok(planMovilDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody PlanMovilDTO planMovilDTO) throws URISyntaxException {
        return planMovilServicio.guardarPlanMovil(planMovilDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPlanMovil(@PathVariable Long id, @RequestBody PlanMovilDTO planMovilDTO){
        return planMovilServicio.actualizarPlanMovil(id, planMovilDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            planMovilServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}