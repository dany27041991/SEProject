package com.example.universitySE.domain;
// Generated 2-feb-2019 18.39.07 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Reporting generated by hbm2java
 */
@Entity
@Table(name="Reporting"
    ,catalog="se_database"
)
public class Reporting  implements java.io.Serializable {


     private long id;
     private String noteProf;
     private int supportMaterialProf;
     private String noteSec;
     private int state;
     private int idProf;
     private Integer idSecretary;
     private int idClassroom;

    public Reporting() {
    }

	
    public Reporting(String noteProf, int supportMaterialProf, int state, int idProf, int idClassroom) {
        this.noteProf = noteProf;
        this.supportMaterialProf = supportMaterialProf;
        this.state = state;
        this.idProf = idProf;
        this.idClassroom = idClassroom;
    }
    public Reporting(String noteProf, int supportMaterialProf, String noteSec, int state, int idProf, Integer idSecretary, int idClassroom) {
       this.noteProf = noteProf;
       this.supportMaterialProf = supportMaterialProf;
       this.noteSec = noteSec;
       this.state = state;
       this.idProf = idProf;
       this.idSecretary = idSecretary;
       this.idClassroom = idClassroom;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
    @Column(name="note_prof", nullable=false, length=65535)
    public String getNoteProf() {
        return this.noteProf;
    }
    
    public void setNoteProf(String noteProf) {
        this.noteProf = noteProf;
    }

    
    @Column(name="support_material_prof", nullable=false)
    public int getSupportMaterialProf() {
        return this.supportMaterialProf;
    }
    
    public void setSupportMaterialProf(int supportMaterialProf) {
        this.supportMaterialProf = supportMaterialProf;
    }

    
    @Column(name="note_sec", length=65535)
    public String getNoteSec() {
        return this.noteSec;
    }
    
    public void setNoteSec(String noteSec) {
        this.noteSec = noteSec;
    }

    
    @Column(name="state", nullable=false)
    public int getState() {
        return this.state;
    }
    
    public void setState(int state) {
        this.state = state;
    }

    
    @Column(name="id_prof", nullable=false)
    public int getIdProf() {
        return this.idProf;
    }
    
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    
    @Column(name="id_secretary")
    public Integer getIdSecretary() {
        return this.idSecretary;
    }
    
    public void setIdSecretary(Integer idSecretary) {
        this.idSecretary = idSecretary;
    }

    
    @Column(name="id_classroom", nullable=false)
    public int getIdClassroom() {
        return this.idClassroom;
    }
    
    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }




}


