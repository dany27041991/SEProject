package com.example.universitySE.domain;
// Generated 24-gen-2019 10.24.28 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;
import java.util.Date;

/**
 * BookExam generated by hbm2java
 */
@Entity
@Table(name="Book_exam"
    ,catalog="se_database"
)
public class BookExam  implements java.io.Serializable {


     private int id;
     private int badgeStudent;
     private int idExam;
     private Date date;

    public BookExam() {
    }

    public BookExam(int id, int badgeStudent, int idExam, Date date) {
       this.id = id;
       this.badgeStudent = badgeStudent;
       this.idExam = idExam;
       this.date = date;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
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




}


