package com.proyecto.soa.servicio;

import com.proyecto.soa.controlador.dto.ConsumoDTO;
import com.proyecto.soa.entidad.Consumo;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IConsumoServicio {
    List<Consumo> encontrarTodos();
    Optional<Consumo> encontrarPorId(Long id);
    void guardar(Consumo consumo);
    void eliminarPorId(Long id);

    ConsumoDTO aDTO(Consumo consumo);
    Consumo desdeDTO(ConsumoDTO consumoDTO);
    List<ConsumoDTO> aDTOList(List<Consumo> consumos);

    ResponseEntity<?> guardarConsumo(ConsumoDTO consumoDTO) throws URISyntaxException;
    ResponseEntity<?> actualizarConsumo(Long id, ConsumoDTO consumoDTO);
}