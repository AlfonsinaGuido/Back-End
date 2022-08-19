/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Controller;

import com.portfolio.yag.Dto.dtoDatosPersonales;
import com.portfolio.yag.Entity.DatosPersonales;
import com.portfolio.yag.Security.Controller.Mensaje;
import com.portfolio.yag.Service.SDatosPersonales;
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
@RequestMapping("/datosPersonales")
/*@CrossOrigin(origins = "http://localhost:4200")*/
@CrossOrigin(origins = "https://alfonsinadvp.web.app")
public class CDatosPersonales {
    @Autowired
    SDatosPersonales sDatosPersonales;
    
    @GetMapping("/lista")
    public ResponseEntity<List<DatosPersonales>> list(){
        List<DatosPersonales> list = sDatosPersonales.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<DatosPersonales> getById(@PathVariable("id")int id){
        if(!sDatosPersonales.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        DatosPersonales DatosPersonales = sDatosPersonales.getOne(id).get();
        return new ResponseEntity(DatosPersonales, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sDatosPersonales.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sDatosPersonales.delete(id);
        return new ResponseEntity(new Mensaje("Dato eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoDatosPersonales dtodatos){
        if(StringUtils.isBlank(dtodatos.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sDatosPersonales.existsByNombreCompleto(dtodatos.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        DatosPersonales DatosPersonales = new DatosPersonales(
                dtodatos.getNombreCompleto(), dtodatos.getProfesion(), dtodatos.getImgPerfil(), dtodatos.getUbicacion(), dtodatos.getCv());
        sDatosPersonales.save(DatosPersonales);
        return new ResponseEntity(new Mensaje("Dato creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDatosPersonales dtodatos){
        if(!sDatosPersonales.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sDatosPersonales.existsByNombreCompleto(dtodatos.getNombreCompleto()) && sDatosPersonales.getByNombreCompleto(dtodatos.getNombreCompleto()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtodatos.getNombreCompleto())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        DatosPersonales DatosPersonales = sDatosPersonales.getOne(id).get();
        
        DatosPersonales.setNombreCompleto(dtodatos.getNombreCompleto());
        DatosPersonales.setProfesion(dtodatos.getProfesion());
        DatosPersonales.setImgPerfil(dtodatos.getImgPerfil());
        DatosPersonales.setUbicacion(dtodatos.getUbicacion());
        DatosPersonales.setCv(dtodatos.getCv());
        
        sDatosPersonales.save(DatosPersonales);
        
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }
}
