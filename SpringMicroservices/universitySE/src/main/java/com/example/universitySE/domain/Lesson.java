package com.example.universitySE.domain;
// Generated 29-gen-2019 8.53.01 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Lesson generated by hbm2java
 */
@Entity
@Table(name="Lesson"
    ,catalog="se_database"
)
public class Lesson  implements java.io.Serializable {


     private int id;

    public Lesson() {
    }

    public Lesson(int id) {
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


