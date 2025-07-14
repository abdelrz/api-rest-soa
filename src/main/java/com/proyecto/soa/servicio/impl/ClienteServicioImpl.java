package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.ClienteDTO;
import com.proyecto.soa.entidad.Cliente;
import com.proyecto.soa.persistencia.IClienteDAO;
import com.proyecto.soa.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServicioImpl implements IClienteServicio {
    @Autowired
    private IClienteDAO clienteDAO;
    @Override
    public List<Cliente> encontrarTodos() {
        return clienteDAO.encontrarTodos();
    }
    @Override
    public Optional<Cliente> encontrarPorId(Long id) {
        return clienteDAO.encontrarPorId(id);
    }
    @Override
    public void guardar(Cliente cliente) {
        clienteDAO.guardar(cliente);
    }
    @Override
    public void eliminarPorId(Long id) {
        clienteDAO.eliminarPorId(id);
    }
    @Override
    public ClienteDTO aDTO(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .correo(cliente.getCorreo())
                .telefono(cliente.getTelefono())
                .contratoList(cliente.getContratoList())
                .ticketSoporteList(cliente.getTicketSoporteList())
                .build();
    }
    @Override
    public Cliente desdeDTO(ClienteDTO clienteDTO) {
        return Cliente.builder()
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .dni(clienteDTO.getDni())
                .correo(clienteDTO.getCorreo())
                .telefono(clienteDTO.getTelefono())
                .build();
    }
    @Override
    public List<ClienteDTO> aDTOList(List<Cliente> clientes) {
        return clientes.stream().map(this::aDTO).collect(Collectors.toList());
    }
    @Override
    public ResponseEntity<?> guardarCliente(ClienteDTO clienteDTO) throws URISyntaxException {
        if (clienteDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Cliente cliente = desdeDTO(clienteDTO);
        guardar(cliente);
        return ResponseEntity.created(new URI("/api/cliente/guardar")).build();
    }
    @Override
    public ResponseEntity<?> actualizarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = encontrarPorId(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setApellido(clienteDTO.getApellido());
            cliente.setDni(clienteDTO.getDni());
            cliente.setCorreo(clienteDTO.getCorreo());
            cliente.setTelefono(clienteDTO.getTelefono());
            guardar(cliente);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}
