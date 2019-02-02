package com.example.universitySE.domain;
// Generated 31-gen-2019 19.39.58 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * StudyCourse generated by hbm2java
 */
@Entity
@Table(name="Study_course"
    ,catalog="se_database"
)
public class StudyCourse  implements java.io.Serializable {


     private Integer id;
     private String name;
     private int faculty;

    public StudyCourse() {
    }

    public StudyCourse(String name, int faculty) {
       this.name = name;
       this.faculty = faculty;
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

    
    @Column(name="faculty", nullable=false)
    public int getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }




}


