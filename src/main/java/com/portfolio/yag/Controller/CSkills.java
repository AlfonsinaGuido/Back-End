
package com.portfolio.yag.Controller;

import com.portfolio.yag.Dto.dtoSkills;
import com.portfolio.yag.Entity.Skills;
import com.portfolio.yag.Security.Controller.Mensaje;
import com.portfolio.yag.Service.SSkills;
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
@RequestMapping("/skills")
/*@CrossOrigin(origins = "http://localhost:4200")*/
@CrossOrigin(origins = "https://alfonsinadvp.web.app")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill){
        if(StringUtils.isBlank(dtoskill.getNameSkill())){
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (sSkills.existsByNameSkill(dtoskill.getNameSkill())){
            return new ResponseEntity(new Mensaje("Skill ya agregada anteriormente"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = new Skills(
                dtoskill.getNameSkill(),
                dtoskill.getProgress(),
                dtoskill.getImgSkill());
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sSkills.existsByNameSkill(dtoskill.getNameSkill()) && sSkills.getByNameSkill(dtoskill.getNameSkill()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskill.getNameSkill())){
            return new ResponseEntity(new Mensaje ("Estae campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = sSkills.getOne(id).get();
        skills.setNameSkill(dtoskill.getNameSkill());
        skills.setProgress(dtoskill.getProgress());
        skills.setImgSkill(dtoskill.getImgSkill());
        
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Se actualizó correctamente esta Skill"),HttpStatus.OK);
    }
    
    
}
