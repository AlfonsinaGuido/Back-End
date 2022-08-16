/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Service;

import com.portfolio.yag.Entity.DatosPersonales;
import com.portfolio.yag.Repository.RDatosPersonales;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SDatosPersonales {
    @Autowired
    RDatosPersonales rDatosPersonales;
    
    public List<DatosPersonales> list(){
        return rDatosPersonales.findAll();
    }
    
    public Optional<DatosPersonales> getOne(int id){
        return rDatosPersonales.findById(id);
    }
    
    public Optional<DatosPersonales> getByNombreCompleto(String nombreCompleto){
        return rDatosPersonales.findByNombreCompleto(nombreCompleto);
    }
    
    public void save(DatosPersonales datos){
        rDatosPersonales.save(datos);
    }
    
    public void delete(int id){
        rDatosPersonales.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rDatosPersonales.existsById(id);
    }
    
    public boolean existsByNombreCompleto(String nombreCompleto){
        return rDatosPersonales.existsByNombreCompleto(nombreCompleto);
    }
}