package com.example.universitySE.domain;
// Generated 28-gen-2019 15.27.48 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TeachingMaterial generated by hbm2java
 */
@Entity
@Table(name="Teaching_material"
    ,catalog="se_database"
)
public class TeachingMaterial  implements java.io.Serializable {


     private int id;
     private int subject;
     private String media;
     private String note;

    public TeachingMaterial() {
    }

	
    public TeachingMaterial(int id, int subject, String media) {
        this.id = id;
        this.subject = subject;
        this.media = media;
    }
    public TeachingMaterial(int id, int subject, String media, String note) {
       this.id = id;
       this.subject = subject;
       this.media = media;
       this.note = note;
    }
   
     @Id

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
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

    
    @Column(name="note", length=65535)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }




}


