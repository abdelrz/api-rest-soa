package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.ContratoServicio;
import com.proyecto.soa.persistencia.IContratoServicioDAO;
import com.proyecto.soa.repositorio.ContratoServicioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContratoServicioDAOImpl implements IContratoServicioDAO {

    @Autowired
    private ContratoServicioRepositorio contratoServicioRepositorio;
    
    @Override
    public List<ContratoServicio> encontrarTodos() {
        return (List<ContratoServicio>) contratoServicioRepositorio.findAll();
    }
    
    @Override
    public Optional<ContratoServicio> encontrarPorId(Long id) {
        return contratoServicioRepositorio.findById(id);
    }
    
    @Override
    public void guardar(ContratoServicio contratoServicio) {
        contratoServicioRepositorio.save(contratoServicio);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        contratoServicioRepositorio.deleteById(id);
    }
}