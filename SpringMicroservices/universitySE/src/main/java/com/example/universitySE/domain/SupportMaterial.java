package com.example.universitySE.domain;
// Generated 28-gen-2019 15.27.48 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SupportMaterial generated by hbm2java
 */
@Entity
@Table(name="Support_material"
    ,catalog="se_database"
)
public class SupportMaterial  implements java.io.Serializable {


     private int id;
     private String name;

    public SupportMaterial() {
    }

    public SupportMaterial(int id, String name) {
       this.id = id;
       this.name = name;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


