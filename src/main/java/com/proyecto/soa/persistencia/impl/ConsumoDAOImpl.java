package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.Consumo;
import com.proyecto.soa.persistencia.IConsumoDAO;
import com.proyecto.soa.repositorio.ConsumoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsumoDAOImpl implements IConsumoDAO {
    
    @Autowired
    private ConsumoRepositorio consumoRepositorio;
    
    @Override
    public List<Consumo> encontrarTodos() {
        return (List<Consumo>) consumoRepositorio.findAll();
    }
    
    @Override
    public Optional<Consumo> encontrarPorId(Long id) {
        return consumoRepositorio.findById(id);
    }
    
    @Override
    public void guardar(Consumo consumo) {
        consumoRepositorio.save(consumo);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        consumoRepositorio.deleteById(id);
    }
}