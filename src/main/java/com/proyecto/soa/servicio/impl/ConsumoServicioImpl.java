package com.proyecto.soa.servicio.impl;

import com.proyecto.soa.controlador.dto.ConsumoDTO;
import com.proyecto.soa.entidad.Consumo;
import com.proyecto.soa.persistencia.IConsumoDAO;
import com.proyecto.soa.servicio.IConsumoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsumoServicioImpl implements IConsumoServicio {
    @Autowired
    private IConsumoDAO consumoDAO;

    @Override
    public List<Consumo> encontrarTodos() {
        return consumoDAO.encontrarTodos();
    }

    @Override
    public Optional<Consumo> encontrarPorId(Long id) {
        return consumoDAO.encontrarPorId(id);
    }

    @Override
    public void guardar(Consumo consumo) {
        consumoDAO.guardar(consumo);
    }

    @Override
    public void eliminarPorId(Long id) {
        consumoDAO.eliminarPorId(id);
    }

    @Override
    public ConsumoDTO aDTO(Consumo consumo) {
        return ConsumoDTO.builder()
                .id(consumo.getId())
                .gbConsumido(consumo.getGbConsumido())
                .minutoConsumido(consumo.getMinutoConsumido())
                .smsConsumido(consumo.getSmsConsumido())
                .contrato(consumo.getContrato())
                .build();
    }

    @Override
    public Consumo desdeDTO(ConsumoDTO consumoDTO) {
        return Consumo.builder()
                .gbConsumido(consumoDTO.getGbConsumido())
                .minutoConsumido(consumoDTO.getMinutoConsumido())
                .smsConsumido(consumoDTO.getSmsConsumido())
                .build();
    }

    @Override
    public List<ConsumoDTO> aDTOList(List<Consumo> consumos) {
        return consumos.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> guardarConsumo(ConsumoDTO consumoDTO) throws URISyntaxException {
        if (consumoDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Consumo consumo = desdeDTO(consumoDTO);
        guardar(consumo);
        return ResponseEntity.created(new URI("/api/consumo/guardar")).build();
    }

    @Override
    public ResponseEntity<?> actualizarConsumo(Long id, ConsumoDTO consumoDTO) {
        Optional<Consumo> consumoOptional = encontrarPorId(id);
        if (consumoOptional.isPresent()) {
            Consumo consumo = consumoOptional.get();
            consumo.setGbConsumido(consumoDTO.getGbConsumido());
            consumo.setMinutoConsumido(consumoDTO.getMinutoConsumido());
            consumo.setSmsConsumido(consumoDTO.getSmsConsumido());
            guardar(consumo);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
}