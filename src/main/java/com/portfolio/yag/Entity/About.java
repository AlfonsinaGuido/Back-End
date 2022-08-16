
package com.portfolio.yag.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class About {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     private int id;
     private String about;

    public About() {
    }

    public About(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
     
    
}
