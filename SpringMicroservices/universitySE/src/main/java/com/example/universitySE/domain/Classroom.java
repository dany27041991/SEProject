package com.example.universitySE.domain;
// Generated 28-gen-2019 15.27.48 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Classroom generated by hbm2java
 */
@Entity
@Table(name="Classroom"
    ,catalog="se_database"
)
public class Classroom  implements java.io.Serializable {


     private int id;
     private String name;
     private BigDecimal latitude;
     private BigDecimal longitude;

    public Classroom() {
    }

    public Classroom(int id, String name, BigDecimal latitude, BigDecimal longitude) {
       this.id = id;
       this.name = name;
       this.latitude = latitude;
       this.longitude = longitude;
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

    
    @Column(name="latitude", nullable=false, precision=9, scale=6)
    public BigDecimal getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    
    @Column(name="longitude", nullable=false, precision=9, scale=6)
    public BigDecimal getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }




}


