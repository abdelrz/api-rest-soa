package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.ServicioAdicional;
import com.proyecto.soa.persistencia.IServicioAdicionalDAO;
import com.proyecto.soa.repositorio.ServicioAdicionalRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServicioAdicionalDAOImpl implements IServicioAdicionalDAO {

    @Autowired
    private ServicioAdicionalRepositorio servicioAdicionalRepositorio;
    
    @Override
    public List<ServicioAdicional> encontrarTodos() {
        return (List<ServicioAdicional>) servicioAdicionalRepositorio.findAll();
    }
    
    @Override
    public Optional<ServicioAdicional> encontrarPorId(Long id) {
        return servicioAdicionalRepositorio.findById(id);
    }
    
    @Override
    public void guardar(ServicioAdicional servicioAdicional) {
        servicioAdicionalRepositorio.save(servicioAdicional);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        servicioAdicionalRepositorio.deleteById(id);
    }
}