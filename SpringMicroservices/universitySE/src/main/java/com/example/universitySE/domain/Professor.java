package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.13 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;
import java.util.Date;

/**
 * Professor generated by hbm2java
 */
@Entity
@Table(name="Professor"
    ,catalog="se_database"
)
public class Professor  implements java.io.Serializable {


     private long id;
     private String firstName;
     private String lastName;
     private String biography;
     private String receptionTime;
     private int subject;
     private Date dateOfBirth;

    public Professor() {
    }

	
    public Professor(long id, String firstName, String lastName, String receptionTime, int subject, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.receptionTime = receptionTime;
        this.subject = subject;
        this.dateOfBirth = dateOfBirth;
    }
    public Professor(long id, String firstName, String lastName, String biography, String receptionTime, int subject, Date dateOfBirth) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.biography = biography;
       this.receptionTime = receptionTime;
       this.subject = subject;
       this.dateOfBirth = dateOfBirth;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
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

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth", nullable=false, length=10)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }




}


