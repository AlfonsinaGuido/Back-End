
package com.portfolio.yag.Controller;

import com.portfolio.yag.Dto.dtoAbout;
import com.portfolio.yag.Entity.About;
import com.portfolio.yag.Security.Controller.Mensaje;
import com.portfolio.yag.Service.SAbout;
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
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:4200")
public class CAbout {
    @Autowired
    SAbout servAbout;
    
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<About>> list(){
        List<About> list = servAbout.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){
        if(!servAbout.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.NOT_FOUND);
        }
        About about = servAbout.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servAbout.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        servAbout.delete(id);
        return new ResponseEntity(new Mensaje ("About Eliminado"), HttpStatus.OK);
    }
    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoab){
        if (StringUtils.isBlank(dtoab.getAbout())) {
            return new ResponseEntity(new Mensaje ("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servAbout.existsByAbout(dtoab.getAbout())){
            return new ResponseEntity(new Mensaje("ya existente"), HttpStatus.BAD_REQUEST);
        }
        
        About about = new About(
                dtoab.getAbout());
        
        servAbout.save(about);
        return new ResponseEntity(new Mensaje("About Creada"), HttpStatus.OK);
     }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoab){
        if (!servAbout.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.NOT_FOUND);
        }
        if(servAbout.existsByAbout(dtoab.getAbout()) && servAbout.getByAbout(dtoab.getAbout()).get().getId() !=id){
            
            return new ResponseEntity(new Mensaje("Existente"), HttpStatus.BAD_REQUEST); //// aca dijo que la descripcion(ver que campo es equivaklente mio, lo tengo que hacer yo
        }
        
        if(StringUtils.isBlank(dtoab.getAbout())){
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        About about = servAbout.getOne(id).get();
        about.setAbout(dtoab.getAbout());
        
        
       
        
        servAbout.save(about);
        return new ResponseEntity(new Mensaje ("se actualizo correctamente"), HttpStatus.OK);
        
        
    
    }
    
    
    
    
    
    
    
    
    
    
}
