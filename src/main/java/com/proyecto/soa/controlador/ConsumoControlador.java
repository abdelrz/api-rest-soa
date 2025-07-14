package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.ConsumoDTO;
import com.proyecto.soa.entidad.Consumo;
import com.proyecto.soa.servicio.IConsumoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumo")
public class ConsumoControlador {
    
    @Autowired
    private IConsumoServicio consumoServicio;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<Consumo> consumoOptional = consumoServicio.encontrarPorId(id);

        if (consumoOptional.isPresent()) {
            ConsumoDTO consumoDTO = consumoServicio.aDTO(consumoOptional.get());
            return ResponseEntity.ok(consumoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<ConsumoDTO> consumoDTOList = consumoServicio.aDTOList(consumoServicio.encontrarTodos());
        return ResponseEntity.ok(consumoDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ConsumoDTO consumoDTO) throws URISyntaxException {
        return consumoServicio.guardarConsumo(consumoDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarConsumo(@PathVariable Long id, @RequestBody ConsumoDTO consumoDTO){
        return consumoServicio.actualizarConsumo(id, consumoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            consumoServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}