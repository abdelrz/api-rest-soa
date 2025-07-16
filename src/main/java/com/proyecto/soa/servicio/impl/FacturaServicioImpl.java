package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.FacturaDTO;
import com.proyecto.soa.entidad.Factura;
import com.proyecto.soa.persistencia.IFacturaDAO;
import com.proyecto.soa.servicio.IFacturaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaServicioImpl implements IFacturaServicio {
    @Autowired
    private IFacturaDAO facturaDAO;

    @Override
    public List<Factura> encontrarTodos() {
        return facturaDAO.encontrarTodos();
    }

    @Override
    public Optional<Factura> encontrarPorId(Long id) {
        return facturaDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(Factura factura) {
        facturaDAO.guardar(factura);
    }

    @Override
    public void eliminarPorId(Long id) {
        facturaDAO.eliminarPorId(id);
    }

    @Override
    public FacturaDTO aDTO(Factura factura) {
        return FacturaDTO.builder()
                .id(factura.getId())
                .fechaEmision(factura.getFechaEmision())
                .fechaVencimiento(factura.getFechaVencimiento())
                .montoTotal(factura.getMontoTotal())
                .estadoPago(factura.getEstadoPago())
                .metodoPago(factura.getMetodoPago())
                .fechaPago(factura.getFechaPago())
                .numeroFactura(factura.getNumeroFactura())
                .contrato(factura.getContrato())
                .build();
    }

    @Override
    public Factura desdeDTO(FacturaDTO facturaDTO) {
        return Factura.builder()
                .fechaEmision(facturaDTO.getFechaEmision())
                .fechaVencimiento(facturaDTO.getFechaVencimiento())
                .montoTotal(facturaDTO.getMontoTotal())
                .estadoPago(facturaDTO.getEstadoPago())
                .metodoPago(facturaDTO.getMetodoPago())
                .fechaPago(facturaDTO.getFechaPago())
                .numeroFactura(facturaDTO.getNumeroFactura())
                .build();
    }

    @Override
    public List<FacturaDTO> aDTOList(List<Factura> facturas) {
        return facturas.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarFactura(FacturaDTO facturaDTO) throws URISyntaxException {
        if (facturaDTO.getFechaEmision().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Factura factura = desdeDTO(facturaDTO);
        guardar(factura);
        return ResponseEntity.created(new URI("/api/factura/guardar")).build();
    }

    @Override
    public ResponseEntity<?> actualizarFactura(Long id, FacturaDTO facturaDTO) {
        Optional<Factura> facturaOptional = encontrarPorId(id);
        if (facturaOptional.isPresent()) {
            Factura factura = facturaOptional.get();
            factura.setFechaEmision(facturaDTO.getFechaEmision());
            factura.setFechaVencimiento(facturaDTO.getFechaVencimiento());
            factura.setMontoTotal(facturaDTO.getMontoTotal());
            factura.setEstadoPago(facturaDTO.getEstadoPago());
            factura.setMetodoPago(facturaDTO.getMetodoPago());
            factura.setFechaPago(facturaDTO.getFechaPago());
            factura.setNumeroFactura(facturaDTO.getNumeroFactura());

            guardar(factura);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}