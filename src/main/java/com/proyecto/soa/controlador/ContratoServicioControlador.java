package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.ContratoServicioDTO;
import com.proyecto.soa.entidad.ContratoServicio;
import com.proyecto.soa.servicio.IContratoServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratoservicio")
public class ContratoServicioControlador {

    @Autowired
    private IContratoServicioService contratoServicioService;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<ContratoServicio> contratoServicioOptional = contratoServicioService.encontrarPorId(id);

        if (contratoServicioOptional.isPresent()) {
            ContratoServicioDTO contratoServicioDTO = contratoServicioService.aDTO(contratoServicioOptional.get());
            return ResponseEntity.ok(contratoServicioDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<ContratoServicioDTO> contratoServicioServiceDTOList = contratoServicioService.aDTOList(contratoServicioService.encontrarTodos());
        return ResponseEntity.ok(contratoServicioDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ContratoServicioDTO contratoServicioDTO) throws URISyntaxException {
        return contratoServicioService.guardarContratoServicio(contratoServicioDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarContratoServicio(@PathVariable Long id, @RequestBody ContratoServicioDTO contratoServicioDTO){
        return contratoServicioService.actualizarContratoServicio(id, contratoServicioDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            contratoServicioService.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}