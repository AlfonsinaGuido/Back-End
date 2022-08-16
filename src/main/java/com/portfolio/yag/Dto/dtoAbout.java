
package com.portfolio.yag.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAbout {
    
    @NotBlank
    private String about;

    public dtoAbout() {
    }

    public dtoAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
    
    
    
    
}
