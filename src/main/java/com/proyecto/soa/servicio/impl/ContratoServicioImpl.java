package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.ContratoDTO;
import com.proyecto.soa.entidad.Contrato;
import com.proyecto.soa.persistencia.IContratoDAO;
import com.proyecto.soa.servicio.IContratoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoServicioImpl implements IContratoServicio {

    @Autowired
    private IContratoDAO contratoDAO;

    @Override
    public List<Contrato> encontrarTodos() {
        return contratoDAO.encontrarTodos();
    }

    @Override
    public Optional<Contrato> encontrarPorId(Long id) {
        return contratoDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(Contrato contrato) {
        contratoDAO.guardar(contrato);
    }

    @Override
    public void eliminarPorId(Long id) {
        contratoDAO.eliminarPorId(id);
    }

    @Override
    public ContratoDTO aDTO(Contrato contrato) {
        return ContratoDTO.builder()
                .id(contrato.getId())
                .fechaInicio(contrato.getFechaInicio())
                .fechaFin(contrato.getFechaFin())
                .estadoContrato(contrato.getEstadoContrato())
                .numeroMovil(contrato.getNumeroMovil())
                .operadorAnterior(contrato.getOperadorAnterior())
                .cicloFacturacion(contrato.getCicloFacturacion())
                .cliente(contrato.getCliente())
                .planMovil(contrato.getPlanMovil())
                .consumoList(contrato.getConsumoList())
                .contratoServicioList(contrato.getContratoServicioList())
                .facturaList(contrato.getFacturaList())
                .ticketSoporteList(contrato.getTicketSoporteList())
                .build();
    }

    @Override
    public Contrato desdeDTO(ContratoDTO contratoDTO) {
        return Contrato.builder()
                .fechaInicio(contratoDTO.getFechaInicio())
                .fechaFin(contratoDTO.getFechaFin())
                .estadoContrato(contratoDTO.getEstadoContrato())
                .numeroMovil(contratoDTO.getNumeroMovil())
                .operadorAnterior(contratoDTO.getOperadotAnterior())
                .cicloFacturacion(contratoDTO.getCicloFacturacion())
                .build();
    }

    @Override
    public List<ContratoDTO> aDTOList(List<Contrato> contratos) {
        return contratos.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarContrato(ContratoDTO contratoDTO) throws URISyntaxException {
        if (contratoDTO.getFechaInicio().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Contrato contrato = desdeDTO(contratoDTO);
        guardar(contrato);
        return ResponseEntity.created(new URI("/api/contrato/guardar")).build();
    }

    @Override
    public ResponseEntity<?> actualizarContrato(Long id, ContratoDTO contratoDTO) {
        Optional<Contrato> contratoOptional = encontrarPorId(id);
        if (contratoOptional.isPresent()) {
            Contrato contrato = contratoOptional.get();
            contrato.setFechaInicio(contratoDTO.getFechaInicio());
            contrato.setFechaFin(contratoDTO.getMinutoConsumido());
            contrato.setEstadoContrato(contratoDTO.getSmsConsumido());
            contrato.setNumeroMovil(contratoDTO.getNumeroMovil());
            contrato.setOperadorAnterior(contratoDTO.getOperadorAnterior());
            contrato.setCicloFacturacion(contratoDTO.getCicloFacturacion());
            guardar(contrato);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}