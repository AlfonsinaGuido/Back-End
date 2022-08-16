/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Repository;

import com.portfolio.yag.Entity.DatosPersonales;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDatosPersonales extends JpaRepository<DatosPersonales, Integer>{
    public Optional<DatosPersonales> findByNombreCompleto(String nombreCompleto);
    public boolean existsByNombreCompleto(String nombreCompleto);
}
