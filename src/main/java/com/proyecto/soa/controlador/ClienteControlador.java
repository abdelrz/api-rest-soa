package com.proyecto.soa.controlador;

import com.proyecto.soa.controlador.dto.ClienteDTO;
import com.proyecto.soa.entidad.Cliente;
import com.proyecto.soa.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {
    @Autowired
    private IClienteServicio clienteServicio;
    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteServicio.encontrarPorId(id);

        if (clienteOptional.isPresent()) {
            ClienteDTO clienteDTO = clienteServicio.aDTO(clienteOptional.get());
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/encontrarTodos")
    public ResponseEntity<?> encontrarTodos() {
        List<ClienteDTO> clienteDTOList = clienteServicio.aDTOList(clienteServicio.encontrarTodos());
        return ResponseEntity.ok(clienteDTOList);
    }
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        return clienteServicio.guardarCliente(clienteDTO);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        return clienteServicio.actualizarCliente(id, clienteDTO);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null){
            clienteServicio.eliminarPorId(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
