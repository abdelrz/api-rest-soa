package com.proyecto.soa.persistencia.impl;

import com.proyecto.soa.entidad.PlanMovil;
import com.proyecto.soa.persistencia.IPlanMovilDAO;
import com.proyecto.soa.repositorio.PlanMovilRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlanMovilDAOImpl implements IPlanMovilDAO {

    @Autowired
    private PlanMovilRepositorio planMovilRepositorio;
    
    @Override
    public List<PlanMovil> encontrarTodos() {
        return (List<PlanMovil>) planMovilRepositorio.findAll();
    }
    
    @Override
    public Optional<PlanMovil> encontrarPorId(Long id) {
        return planMovilRepositorio.findById(id);
    }
    
    @Override
    public void guardar(PlanMovil planMovil) {
        planMovilRepositorio.save(planMovil);
    }
    
    @Override
    public void eliminarPorId(Long id) {
        planMovilRepositorio.deleteById(id);
    }
}