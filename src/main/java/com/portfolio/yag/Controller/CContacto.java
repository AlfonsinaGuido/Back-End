/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Controller;

import com.portfolio.yag.Dto.dtoContacto;
import com.portfolio.yag.Entity.Contacto;
import com.portfolio.yag.Security.Controller.Mensaje;
import com.portfolio.yag.Service.SContacto;
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
@RequestMapping("/contacto")
/*@CrossOrigin(origins = "http://localhost:4200")*/
@CrossOrigin(origins = "https://alfonsinadvp.web.app")
public class CContacto {
    @Autowired
    SContacto sContacto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Contacto>> list(){
        List<Contacto> list = sContacto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id")int id){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Contacto Contacto = sContacto.getOne(id).get();
        return new ResponseEntity(Contacto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sContacto.delete(id);
        return new ResponseEntity(new Mensaje("Contacto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContacto dtocontacto){
        if(StringUtils.isBlank(dtocontacto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sContacto.existsByEmail(dtocontacto.getEmail())){
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Contacto Contacto = new Contacto(
                dtocontacto.getEmail(), dtocontacto.getTelefono(), dtocontacto.getOtroMedio());
        sContacto.save(Contacto);
        return new ResponseEntity(new Mensaje("Contacto creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContacto dtocontacto){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sContacto.existsByEmail(dtocontacto.getEmail()) && sContacto.getByEmail(dtocontacto.getEmail()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtocontacto.getEmail())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Contacto Contacto = sContacto.getOne(id).get();
        
        Contacto.setEmail(dtocontacto.getEmail());
        Contacto.setTelefono(dtocontacto.getTelefono());
        Contacto.setOtroMedio(dtocontacto.getOtroMedio());
        
        sContacto.save(Contacto);
        
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }
}
