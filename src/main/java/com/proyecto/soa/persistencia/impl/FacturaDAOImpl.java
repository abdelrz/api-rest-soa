package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.Factura;
import com.proyecto.soa.persistencia.IFacturaDAO;
import com.proyecto.soa.repositorio.FacturaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FacturaDAOImpl implements IFacturaDAO {

    @Autowired
    private FacturaRepositorio facturaRepositorio;
    
    @Override
    public List<Factura> encontrarTodos() {
        return (List<Factura>) facturaRepositorio.findAll();
    }
    
    @Override
    public Optional<Factura> encontrarPorId(Long id) {
        return facturaRepositorio.findById(id);
    }
    
    @Override
    public void guardar(Factura factura) {
        facturaRepositorio.save(factura);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        facturaRepositorio.deleteById(id);
    }
}