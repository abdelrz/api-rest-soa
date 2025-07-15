package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.FacturaDTO;
import com.proyecto.soa.entidad.Factura;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IFacturaServicio {
    List<Factura> encontrarTodos();
    Optional<Factura> encontrarPorId(Long id);
    void guardar(Factura factura);
    void eliminarPorId(Long id);

    FacturaDTO aDTO(Factura factura);
    Factura desdeDTO(FacturaDTO facturaDTO);
    List<FacturaDTO> aDTOList(List<Factura> facturas);

    ResponseEntity<?> guardarFactura(FacturaDTO facturaDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarFactura(Long id, FacturaDTO facturaDTO);
}