package com.example.universitySE.domain;
// Generated 31-gen-2019 19.39.58 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exam generated by hbm2java
 */
@Entity
@Table(name="Exam"
    ,catalog="se_database"
)
public class Exam  implements java.io.Serializable {


     private int id;

    public Exam() {
    }

    public Exam(int id) {
       this.id = id;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }




}


