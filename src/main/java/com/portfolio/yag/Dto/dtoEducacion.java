/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private String logoE;
    private String periodoAniosE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String logoE, String periodoAniosE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
        this.periodoAniosE = periodoAniosE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    public String getLogoE() {
        return logoE;
    }

    public void setLogoE(String logoE) {
        this.logoE = logoE;
    }

    public String getPeriodoAniosE() {
        return periodoAniosE;
    }

    public void setPeriodoAñosE(String periodoAniosE) {
        this.periodoAniosE = periodoAniosE;
    }
    
}

