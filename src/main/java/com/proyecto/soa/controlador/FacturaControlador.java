package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.FacturaDTO;
import com.proyecto.soa.entidad.Factura;
import com.proyecto.soa.servicio.IFacturaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factura")
public class FacturaControlador {
    
    @Autowired
    private IFacturaServicio facturaServicio;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<Factura> facturaOptional = facturaServicio.encontrarPorId(id);

        if (facturaOptional.isPresent()) {
            FacturaDTO facturaDTO = facturaServicio.aDTO(facturaOptional.get());
            return ResponseEntity.ok(facturaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<FacturaDTO> facturaDTOList = facturaServicio.aDTOList(facturaServicio.encontrarTodos());
        return ResponseEntity.ok(facturaDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody FacturaDTO facturaDTO) throws URISyntaxException {
        return facturaServicio.guardarFactura(facturaDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarFactura(@PathVariable Long id, @RequestBody FacturaDTO facturaDTO){
        return facturaServicio.actualizarFactura(id, facturaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            facturaServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}