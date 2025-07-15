package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.ServicioAdicionalDTO;
import com.proyecto.soa.entidad.ServicioAdicional;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IServicioAdicionalServicio {
    List<ServicioAdicional> encontrarTodos();
    Optional<ServicioAdicional> encontrarPorId(Long id);
    void guardar(ServicioAdicional servicioAdicional);
    void eliminarPorId(Long id);

    ServicioAdicionalDTO aDTO(ServicioAdicional servicioAdicional);
    ServicioAdicional desdeDTO(ServicioAdicionalDTO servicioAdicionalDTO);
    List<ServicioAdicionalDTO> aDTOList(List<ServicioAdicional> serviciosadicionales);

    ResponseEntity<?> guardarServicioAdicional(ServicioAdicionalDTO servicioAdicionalDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarServicioAdicional(Long id, ServicioAdicionalDTO servicioAdicionalDTO);
}