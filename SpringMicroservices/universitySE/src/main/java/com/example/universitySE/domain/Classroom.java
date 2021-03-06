package com.example.universitySE.domain;
// Generated 14-feb-2019 21.58.38 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Classroom generated by hbm2java
 */
@Entity
@Table(name="Classroom"
    ,catalog="se_database"
)
public class Classroom  implements java.io.Serializable {


     private Integer id;
     private String name;
     private BigDecimal latitude;
     private BigDecimal longitude;

    public Classroom() {
    }

    public Classroom(String name, BigDecimal latitude, BigDecimal longitude) {
       this.name = name;
       this.latitude = latitude;
       this.longitude = longitude;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
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


