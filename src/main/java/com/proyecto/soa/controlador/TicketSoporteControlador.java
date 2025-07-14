package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.TicketSoporteDTO;
import com.proyecto.soa.entidad.TicketSoporte;
import com.proyecto.soa.servicio.ITicketSoporteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticketsoporte")
public class TicketSoporteControlador {
    
    @Autowired
    private ITicketSoporteServicio ticketSoporteServicio;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<TicketSoporte> ticketSoporteOptional = ticketSoporteServicio.encontrarPorId(id);

        if (ticketSoporteOptional.isPresent()) {
            TicketSoporteDTO ticketSoporteDTO = ticketSoporteServicio.aDTO(ticketSoporteOptional.get());
            return ResponseEntity.ok(ticketSoporteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<TicketSoporteDTO> ticketSoporteDTOList = ticketSoporteServicio.aDTOList(ticketSoporteServicio.encontrarTodos());
        return ResponseEntity.ok(ticketSoporteDTOList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody TicketSoporteDTO ticketSoporteDTO) throws URISyntaxException {
        return ticketSoporteServicio.guardarTicketSoporte(ticketSoporteDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarTicketSoporte(@PathVariable Long id, @RequestBody TicketSoporteDTO ticketSoporteDTO){
        return ticketSoporteServicio.actualizarTicketSoporte(id, ticketSoporteDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            ticketSoporteServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}