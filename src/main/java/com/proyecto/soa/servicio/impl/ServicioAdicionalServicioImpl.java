package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.ServicioAdicionalDTO;
import com.proyecto.soa.entidad.ServicioAdicional;
import com.proyecto.soa.persistencia.IServicioAdicionalDAO;
import com.proyecto.soa.servicio.IServicioAdicionalServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioAdicionalServicioImpl implements IServicioAdicionalServicio {
    @Autowired
    private IServicioAdicionalDAO servicioAdicionalDAO;

    @Override
    public List<ServicioAdicional> encontrarTodos() {
        return servicioAdicionalDAO.encontrarTodos();
    }

    @Override
    public Optional<ServicioAdicional> encontrarPorId(Long id) {
        return servicioAdicionalDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(ServicioAdicional servicioAdicional) {
        servicioAdicionalDAO.guardar(servicioAdicional);
    }

    @Override
    public void eliminarPorId(Long id) {
        servicioAdicionalDAO.eliminarPorId(id);
    }

    @Override
    public ServicioAdicionalDTO aDTO(ServicioAdicional servicioAdicional) {
        return ServicioAdicionalDTO.builder()
                .id(servicioAdicional.getId())
                .nombre(servicioAdicional.getNombre())
                .descripcion(servicioAdicional.getDescripcion())
                .precio(servicioAdicional.getPrecio())
                .tipoServicio(servicioAdicional.getTipoServicio())
                .contratoServicioList(servicioAdicional.getContratoServicioList())
                .build();
    }

    @Override
    public ServicioAdicional desdeDTO(ServicioAdicionalDTO servicioAdicionalDTO) {
        return ServicioAdicional.builder()
                .nombre(servicioAdicionalDTO.getNombre())
                .descripcion(servicioAdicionalDTO.getDescripcion())
                .precio(servicioAdicionalDTO.getPrecio())
                .tipoServicio(servicioAdicionalDTO.getTipoServicio())
                .contratoServicioList(servicioAdicionalDTO.getContratoServicioList())
                .build();
    }
    
    @Override
    public List<ServicioAdicionalDTO> aDTOList(List<ServicioAdicional> serviciosadicionales) {
        return serviciosadicionales.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarServicioAdicional(ServicioAdicionalDTO servicioAdicionalDTO) throws URISyntaxException {
        if (servicioAdicionalDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        ServicioAdicional servicioAdicional = desdeDTO(servicioAdicionalDTO);
        guardar(servicioAdicional);
        return ResponseEntity.created(new URI("/api/servicioadicional/guardar")).build();
    }
    
    @Override
    public ResponseEntity<?> actualizarServicioAdicional(Long id, ServicioAdicionalDTO servicioAdicionalDTO) {
        Optional<ServicioAdicional> servicioAdicionalOptional = encontrarPorId(id);
        if (servicioAdicionalOptional.isPresent()) {
            ServicioAdicional servicioAdicional = servicioAdicionalOptional.get();
            servicioAdicional.setNombre(servicioAdicionalDTO.getNombre());
            servicioAdicional.setDescripcion(servicioAdicionalDTO.getDescripcion());
            servicioAdicional.setPrecio(servicioAdicionalDTO.getPrecio());
            servicioAdicional.setTipoServicio(servicioAdicionalDTO.getTipoServicio());
            guardar(servicioAdicional);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}