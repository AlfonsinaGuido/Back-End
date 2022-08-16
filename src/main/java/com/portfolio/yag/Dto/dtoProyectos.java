
package com.portfolio.yag.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {
    @NotBlank
     private String nombreProy;
    @NotBlank
     private String descProy;
    @NotBlank
     private String webProy;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreProy, String descProy, String webProy) {
        this.nombreProy = nombreProy;
        this.descProy = descProy;
        this.webProy = webProy;
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
