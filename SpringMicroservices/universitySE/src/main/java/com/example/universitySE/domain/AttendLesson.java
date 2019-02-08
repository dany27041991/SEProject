package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.13 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * AttendLesson generated by hbm2java
 */
@Entity
@Table(name="Attend_lesson"
    ,catalog="se_database"
)
public class AttendLesson  implements java.io.Serializable {


     private long id;
     private int feedback;
     private int idLesson;
     private int badgeStudent;

    public AttendLesson() {
    }

    public AttendLesson(int feedback, int idLesson, int badgeStudent) {
       this.feedback = feedback;
       this.idLesson = idLesson;
       this.badgeStudent = badgeStudent;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
    @Column(name="feedback", nullable=false)
    public int getFeedback() {
        return this.feedback;
    }
    
    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    
    @Column(name="id_lesson", nullable=false)
    public int getIdLesson() {
        return this.idLesson;
    }
    
    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    
    @Column(name="badge_student", nullable=false)
    public int getBadgeStudent() {
        return this.badgeStudent;
    }
    
    public void setBadgeStudent(int badgeStudent) {
        this.badgeStudent = badgeStudent;
    }




}


