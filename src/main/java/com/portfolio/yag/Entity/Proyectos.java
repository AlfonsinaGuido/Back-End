
package com.portfolio.yag.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Proyectos {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     private int id;
     private String nombreProy;
     private String descProy;
     private String webProy;

    public Proyectos() {
    }

    public Proyectos(String nombreProy, String descProy, String webProy) {
        this.nombreProy = nombreProy;
        this.descProy = descProy;
        this.webProy = webProy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getDescProy() {
        return descProy;
    }

    public void setDescProy(String descProy) {
        this.descProy = descProy;
    }

    public String getWebProy() {
        return webProy;
    }

    public void setWebProy(String webProy) {
        this.webProy = webProy;
    }
     
    
    
}
