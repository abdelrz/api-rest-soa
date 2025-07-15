package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.ContratoDTO;
import com.proyecto.soa.entidad.Contrato;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IContratoServicio {
    List<Contrato> encontrarTodos();
    Optional<Contrato> encontrarPorId(Long id);
    void guardar(Contrato contrato);
    void eliminarPorId(Long id);

    ContratoDTO aDTO(Contrato contrato);
    Contrato desdeDTO(ContratoDTO contratoDTO);
    List<ContratoDTO> aDTOList(List<Contrato> contratos);

    ResponseEntity<?> guardarContrato(ContratoDTO contratoDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarContrato(Long id, ContratoDTO contratoDTO);
}