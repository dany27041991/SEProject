package com.example.universitySE.domain;
// Generated 23-gen-2019 19.26.45 by Hibernate Tools 5.2.0.Final


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
     private int evaluation;

    public Exam() {
    }

    public Exam(int id, int evaluation) {
       this.id = id;
       this.evaluation = evaluation;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="evaluation", nullable=false)
    public int getEvaluation() {
        return this.evaluation;
    }
    
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }




}

