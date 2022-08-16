/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Dto;

import javax.validation.constraints.NotBlank;

public class dtoDatosPersonales {
    @NotBlank
    private String nombreCompleto;
    @NotBlank
    private String profesion;
    private String imgPerfil;
    private String ubicacion;
    private String cv;

    public dtoDatosPersonales() {
    }

    public dtoDatosPersonales(String nombreCompleto, String profesion, String imgPerfil, String ubicacion, String cv) {
        this.nombreCompleto = nombreCompleto;
        this.profesion = profesion;
        this.imgPerfil = imgPerfil;
        this.ubicacion = ubicacion;
        this.cv = cv;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    
}
