package com.example.universitySE.domain;
// Generated 29-gen-2019 18.51.31 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StudyCourse generated by hbm2java
 */
@Entity
@Table(name="Study_course"
    ,catalog="se_database"
)
public class StudyCourse  implements java.io.Serializable {


     private int id;
     private String name;
     private int faculty;

    public StudyCourse() {
    }

    public StudyCourse(int id, String name, int faculty) {
       this.id = id;
       this.name = name;
       this.faculty = faculty;
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

    
    @Column(name="faculty", nullable=false)
    public int getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }




}


