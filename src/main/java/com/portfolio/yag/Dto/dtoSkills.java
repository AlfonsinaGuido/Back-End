
package com.portfolio.yag.Dto;

import javax.validation.constraints.NotBlank;




public class dtoSkills {
    @NotBlank
    private String nameSkill;
    @NotBlank
    private Long progress;
    @NotBlank
    private String imgSkill;

    public dtoSkills() {
    }

    public dtoSkills(String nameSkill, Long progress, String imgSkill) {
        this.nameSkill = nameSkill;
        this.progress = progress;
        this.imgSkill = imgSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }
    
    
    
    
}