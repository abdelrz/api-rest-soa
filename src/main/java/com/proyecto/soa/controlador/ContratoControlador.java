package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.ContratoDTO;
import com.proyecto.soa.entidad.Contrato;
import com.proyecto.soa.servicio.IContratoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contrato")
public class ContratoControlador {

    @Autowired
    private IContratoServicio contratoServicio;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<Contrato> contratoOptional = contratoServicio.encontrarPorId(id);

        if (contratoOptional.isPresent()) {
            ContratoDTO contratoDTO = contratoServicio.aDTO(contratoOptional.get());
            return ResponseEntity.ok(contratoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<ContratoDTO> contratoDTOList = contratoServicio.aDTOList(contratoServicio.encontrarTodos());
        return ResponseEntity.ok(contratoDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ContratoDTO contratoDTO) throws URISyntaxException {
        return contratoServicio.guardarContrato(contratoDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO){
        return contratoServicio.actualizarContrato(id, contratoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            contratoServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}