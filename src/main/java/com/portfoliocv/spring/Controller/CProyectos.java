/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliocv.spring.Controller;

import com.portfoliocv.spring.Dto.dtoProyectos;
import com.portfoliocv.spring.Entity.Proyecto;
import com.portfoliocv.spring.Security.Controller.Mensaje;
import com.portfoliocv.spring.service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"https://portfolio-frontendpia.web.app"})
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyectos.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombreP())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyectos.existsByNombreP(dtoproyectos.getNombreP())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
                dtoproyectos.getNombreP(), dtoproyectos.getDescripcionP(), dtoproyectos.getLinkP()
            );
        sProyectos.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sProyectos.existsByNombreP(dtoproyectos.getNombreP()) && sProyectos.getByNombreP(dtoproyectos.getNombreP()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getNombreP())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyectos.getOne(id).get();
        
        proyecto.setNombreP(dtoproyectos.getNombreP());
        proyecto.setDescripcionP(dtoproyectos.getDescripcionP());
        proyecto.setLinkP(dtoproyectos.getLinkP());
        
        sProyectos.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}