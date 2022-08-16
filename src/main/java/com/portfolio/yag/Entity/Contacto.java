/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.yag.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     private int id;
     private String email;
     private String telefono;
     private String otroMedio;

    public Contacto() {
    }

    public Contacto(String email, String telefono, String otroMedio) {
        this.email = email;
        this.telefono = telefono;
        this.otroMedio = otroMedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
