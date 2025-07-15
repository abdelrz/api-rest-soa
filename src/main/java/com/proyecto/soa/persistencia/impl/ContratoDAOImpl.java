package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.Contrato;
import com.proyecto.soa.persistencia.IContratoDAO;
import com.proyecto.soa.repositorio.ContratoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContratoDAOImpl implements IContratoDAO {

    @Autowired
    private ContratoRepositorio contratoRepositorio;
    
    @Override
    public List<Contrato> encontrarTodos() {
        return (List<Contrato>) contratoRepositorio.findAll();
    }
    
    @Override
    public Optional<Contrato> encontrarPorId(Long id) {
        return contratoRepositorio.findById(id);
    }
    
    @Override
    public void guardar(Contrato contrato) {
        contratoRepositorio.save(contrato);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        contratoRepositorio.deleteById(id);
    }
}