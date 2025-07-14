package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.ClienteDTO;
import com.proyecto.soa.entidad.Cliente;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IClienteServicio {
    List<Cliente> encontrarTodos();
    Optional<Cliente> encontrarPorId(Long id);
    void guardar(Cliente cliente);
    void eliminarPorId(Long id);

    ClienteDTO aDTO(Cliente cliente);
    Cliente desdeDTO(ClienteDTO clienteDTO);
    List<ClienteDTO> aDTOList(List<Cliente> clientes);

    ResponseEntity<?> guardarCliente(ClienteDTO clienteDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarCliente(Long id, ClienteDTO clienteDTO);
}
