
package com.portfolio.yag.Service;


import com.portfolio.yag.Entity.Proyectos;
import com.portfolio.yag.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class SProyectos {
    @Autowired
    RProyectos rProyectos;
    
    
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    
    
    public Optional<Proyectos> getOne (int id){
        return rProyectos.findById(id);
    
    }
    
    public Optional<Proyectos> getByNombreProy(String nombreProy){
        return rProyectos.findByNombreProy(nombreProy);
    
    }
    
    public void save(Proyectos nombreProy){
        rProyectos.save(nombreProy);
    
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);    
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existsByNombreProy(String nombreProy){
        return rProyectos.existsByNombreProy(nombreProy);
    }
    
    
    
}
