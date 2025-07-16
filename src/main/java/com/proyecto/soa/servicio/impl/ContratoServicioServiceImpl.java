package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.ContratoServicioDTO;
import com.proyecto.soa.entidad.ContratoServicio;
import com.proyecto.soa.persistencia.IContratoServicioDAO;
import com.proyecto.soa.servicio.IContratoServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoServicioServiceImpl implements IContratoServicio {
    @Autowired
    private IContratoServicioDAO contratoServicioDAO;

    @Override
    public List<ContratoServicio> encontrarTodos() {
        return contratoServicioDAO.encontrarTodos();
    }

    @Override
    public Optional<ContratoServicio> encontrarPorId(Long id) {
        return contratoServicioDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(ContratoServicio contratoServicio) {
        contratoServicioDAO.guardar(contratoServicio);
    }

    @Override
    public void eliminarPorId(Long id) {
        contratoServicioDAO.eliminarPorId(id);
    }

    @Override
    public ContratoServicioDTO aDTO(ContratoServicio contratoServicio) {
        return ContratoServicioDTO.builder()
                .id(contratoServicio.getId())
                .fechaActivacion(contratoServicio.getFechaActivacion())
                .fechaDesactivacion(contratoServicio.getFechaDesactivacion())
                .estado(contratoServicio.getEstado())
                .contrato(contratoServicio.getContrato())
                .servicioAdicional(contratoServicio.getServicioAdicional())
                .build();
    }

    @Override
    public ContratoServicio desdeDTO(ContratoServicioDTO contratoServicioDTO) {
        return ContratoServicio.builder()
                .fechaActivacion(contratoServicioDTO.getFechaActivacion())
                .fechaDesactivacion(contratoServicioDTO.getFechaDesactivacion())
                .estado(contratoServicioDTO.getEstado())
                .build();
    }

    @Override
    public List<ContratoServicioDTO> aDTOList(List<ContratoServicio> contratoServicios) {
        return contratoServicios.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarContratoServicio(ContratoServicioDTO contratoServicioDTO) throws URISyntaxException {
        if (contratoServicioDTO.getFechaActivacion().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        ContratoServicio contratoServicio = desdeDTO(contratoServicioDTO);
        guardar(contratoServicio);
        return ResponseEntity.created(new URI("/api/contratoservicio/guardar")).build();
    }

    @Override
    public ResponseEntity<?> actualizarContratoServicio(Long id, ContratoServicioDTO contratoServicioDTO) {
        Optional<ContratoServicio> contratoServicioOptional = encontrarPorId(id);
        if (contratoServicioOptional.isPresent()) {
            ContratoServicio contratoServicio = contratoServicioOptional.get();
            contratoServicio.setFechaActivacion(contratoServicioDTO.getFechaActivacion());
            contratoServicio.setFechaDesactivacion(contratoServicioDTO.getFechaDesactivacion());
            contratoServicio.setEstado(contratoServicioDTO.getEstado());
            guardar(contratoServicio);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}