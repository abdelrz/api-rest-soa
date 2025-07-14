package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.ServicioAdicionalDTO;
import com.proyecto.soa.entidad.ServicioAdicional;
import com.proyecto.soa.servicio.IServicioAdicionalServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicioadicional")
public class ServicioAdicionalControlador {
    
    @Autowired
    private IServicioAdicionalServicio servicioAdicionalServicio;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<ServicioAdicional> servicioAdicionalOptional = servicioAdicionalServicio.encontrarPorId(id);

        if (servicioAdicionalOptional.isPresent()) {
            ServicioAdicionalDTO servicioAdicionalDTO = servicioAdicionalServicio.aDTO(servicioAdicionalOptional.get());
            return ResponseEntity.ok(servicioAdicionalDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<ServicioAdicionalDTO> servicioAdicionalDTOList = servicioAdicionalServicio.aDTOList(servicioAdicionalServicio.encontrarTodos());
        return ResponseEntity.ok(servicioAdicionalDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ServicioAdicionalDTO servicioAdicionalDTO) throws URISyntaxException {
        return servicioAdicionalServicio.guardarServicioAdicional(servicioAdicionalDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarServicioAdicional(@PathVariable Long id, @RequestBody ServicioAdicionalDTO servicioAdicionalDTO){
        return servicioAdicionalServicio.actualizarServicioAdicional(id, servicioAdicionalDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            servicioAdicionalServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}