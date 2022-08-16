/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Service;

import com.portfolio.yag.Entity.Contacto;
import com.portfolio.yag.Repository.RContacto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContacto {
    @Autowired
    RContacto rContacto;
    
    public List<Contacto> list(){
        return rContacto.findAll();
    }
    
    public Optional<Contacto> getOne(int id){
        return rContacto.findById(id);
    }
    
    public Optional<Contacto> getByEmail(String email){
        return rContacto.findByEmail(email);
    }
    
    public void save(Contacto contacto){
        rContacto.save(contacto);
    }
    
    public void delete(int id){
        rContacto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rContacto.existsById(id);
    }
    
    public boolean existsByEmail(String email){
        return rContacto.existsByEmail(email);
    }
}
