/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliocv.spring.service;

import com.portfoliocv.spring.Entity.Proyecto;
import com.portfoliocv.spring.repository.RProyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hp
 */
@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos rProyectos;
    
    public List<Proyecto> list(){
        return rProyectos.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyecto> getByNombreP(String nombreP){
        return rProyectos.findByNombreP(nombreP);
    }
    
    public void save(Proyecto proyecto){
        rProyectos.save(proyecto);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP){
        return rProyectos.existsByNombreP(nombreP);
    }
}
