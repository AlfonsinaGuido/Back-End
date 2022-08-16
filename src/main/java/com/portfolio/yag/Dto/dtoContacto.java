/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author yesic
 */
public class dtoContacto {
    @NotBlank
    private String email;
    @NotBlank
    private String telefono;
    private String otroMedio;
    
    public dtoContacto() {
    }

    public dtoContacto(String email, String telefono, String otroMedio) {
        this.email = email;
        this.telefono = telefono;
        this.otroMedio = otroMedio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOtroMedio() {
        return otroMedio;
    }

    public void setOtroMedio(String otroMedio) {
        this.otroMedio = otroMedio;
    }


    
}
