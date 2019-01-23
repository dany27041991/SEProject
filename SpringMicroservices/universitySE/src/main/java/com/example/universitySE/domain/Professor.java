package com.example.universitySE.domain;
// Generated 23-gen-2019 19.26.45 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Professor generated by hbm2java
 */
@Entity
@Table(name="Professor"
    ,catalog="se_database"
)
public class Professor  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String lastName;
     private String biography;
     private String receptionTime;
     private int subject;

    public Professor() {
    }

	
    public Professor(int id, String firstName, String lastName, String receptionTime, int subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.receptionTime = receptionTime;
        this.subject = subject;
    }
    public Professor(int id, String firstName, String lastName, String biography, String receptionTime, int subject) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.biography = biography;
       this.receptionTime = receptionTime;
       this.subject = subject;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="first_name", nullable=false)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", nullable=false)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="biography")
    public String getBiography() {
        return this.biography;
    }
    
    public void setBiography(String biography) {
        this.biography = biography;
    }

    
    @Column(name="reception_time", nullable=false)
    public String getReceptionTime() {
        return this.receptionTime;
    }
    
    public void setReceptionTime(String receptionTime) {
        this.receptionTime = receptionTime;
    }

    
    @Column(name="subject", nullable=false)
    public int getSubject() {
        return this.subject;
    }
    
    public void setSubject(int subject) {
        this.subject = subject;
    }




}


