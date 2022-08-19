
package com.portfolio.yag.Controller;

import com.portfolio.yag.Dto.dtoProyectos;
import com.portfolio.yag.Entity.Proyectos;
import com.portfolio.yag.Security.Controller.Mensaje;
import com.portfolio.yag.Service.SProyectos;
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
/*@CrossOrigin(origins = "http://localhost:4200")*/
@CrossOrigin(origins = "https://alfonsinadvp.web.app")
public class CProyectos {
    @Autowired
    SProyectos servProy;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = servProy.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!servProy.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.OK);
        }
        Proyectos proyectos = servProy.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servProy.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        servProy.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy){
        if(StringUtils.isBlank(dtoproy.getNombreProy())){
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (servProy.existsByNombreProy(dtoproy.getNombreProy())){
            return new ResponseEntity(new Mensaje("Proyecto ya agregado anteriormente"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = new Proyectos(
                dtoproy.getNombreProy(),
                dtoproy.getDescProy(),
                dtoproy.getWebProy());
        servProy.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproy){
        if(!servProy.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(servProy.existsByNombreProy(dtoproy.getNombreProy()) && servProy.getByNombreProy(dtoproy.getNombreProy()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproy.getNombreProy())){
            return new ResponseEntity(new Mensaje ("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = servProy.getOne(id).get();
        proyectos.setNombreProy(dtoproy.getNombreProy());
        proyectos.setDescProy(dtoproy.getDescProy()); 
        proyectos.setWebProy(dtoproy.getWebProy());
        
        servProy.save(proyectos);
        return new ResponseEntity(new Mensaje("Se actualizó correctamente este Proyecto"),HttpStatus.OK);
    }
    
    
    
    
            
    
}