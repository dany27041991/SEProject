package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.13 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * TeachingMaterial generated by hbm2java
 */
@Entity
@Table(name="Teaching_material"
    ,catalog="se_database"
)
public class TeachingMaterial  implements java.io.Serializable {


     private Integer id;
     private int subject;
     private String media;

    public TeachingMaterial() {
    }

    public TeachingMaterial(int subject, String media) {
       this.subject = subject;
       this.media = media;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="subject", nullable=false)
    public int getSubject() {
        return this.subject;
    }
    
    public void setSubject(int subject) {
        this.subject = subject;
    }

    
    @Column(name="media", nullable=false)
    public String getMedia() {
        return this.media;
    }
    
    public void setMedia(String media) {
        this.media = media;
    }




}


