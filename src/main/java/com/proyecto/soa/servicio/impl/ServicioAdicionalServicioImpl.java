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
}