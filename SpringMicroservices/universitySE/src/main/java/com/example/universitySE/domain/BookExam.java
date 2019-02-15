package com.example.universitySE.domain;
// Generated 14-feb-2019 21.58.38 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * BookExam generated by hbm2java
 */
@Entity
@Table(name="Book_exam"
    ,catalog="se_database"
)
public class BookExam  implements java.io.Serializable {


     private Integer id;
     private int badgeStudent;
     private int idExam;
     private Date date;
     private int evaluation;

    public BookExam() {
    }

    public BookExam(int badgeStudent, int idExam, Date date, int evaluation) {
       this.badgeStudent = badgeStudent;
       this.idExam = idExam;
       this.date = date;
       this.evaluation = evaluation;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="badge_student", nullable=false)
    public int getBadgeStudent() {
        return this.badgeStudent;
    }
    
    public void setBadgeStudent(int badgeStudent) {
        this.badgeStudent = badgeStudent;
    }

    
    @Column(name="id_exam", nullable=false)
    public int getIdExam() {
        return this.idExam;
    }
    
    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", nullable=false, length=19)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    
    @Column(name="evaluation", nullable=false)
    public int getEvaluation() {
        return this.evaluation;
    }
    
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }




}


