package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.ContratoServicioDTO;
import com.proyecto.soa.entidad.ContratoServicio;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IContratoServicioService {
    List<ContratoServicio> encontrarTodos();
    Optional<ContratoServicio> encontrarPorId(Long id);
    void guardar(ContratoServicio contratoServicio);
    void eliminarPorId(Long id);

    ContratoServicioDTO aDTO(ContratoServicio contratoServicio);
    ContratoServicio desdeDTO(ContratoServicioDTO contratoServicioDTO);
    List<ContratoServicioDTO> aDTOList(List<ContratoServicio> contratoservicios);

    ResponseEntity<?> guardarContratoServicio(ContratoServicioDTO contratoServicioDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarContratoServicio(Long id, ContratoServicioDTO contratoServicioDTO);
}