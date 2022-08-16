
package com.portfolio.yag.Repository;

import com.portfolio.yag.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional <Proyectos> findByNombreProy(String nombreProy);
    public Boolean existsByNombreProy(String nombreProy);
    
}