package com.example.universitySE.domain;
// Generated 24-gen-2019 10.24.28 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;
import java.util.Date;

/**
 * Activity generated by hbm2java
 */
@Entity
@Table(name="Activity"
    ,catalog="se_database"
)
public class Activity  implements java.io.Serializable {


     private int id;
     private int studyCourse;
     private int subject;
     private int idProf;
     private Date start;
     private Date end;
     private int classroomName;

    public Activity() {
    }

    public Activity(int id, int studyCourse, int subject, int idProf, Date start, Date end, int classroomName) {
       this.id = id;
       this.studyCourse = studyCourse;
       this.subject = subject;
       this.idProf = idProf;
       this.start = start;
       this.end = end;
       this.classroomName = classroomName;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="study_course", nullable=false)
    public int getStudyCourse() {
        return this.studyCourse;
    }
    
    public void setStudyCourse(int studyCourse) {
        this.studyCourse = studyCourse;
    }

    
    @Column(name="subject", nullable=false)
    public int getSubject() {
        return this.subject;
    }
    
    public void setSubject(int subject) {
        this.subject = subject;
    }

    
    @Column(name="id_prof", nullable=false)
    public int getIdProf() {
        return this.idProf;
    }
    
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start", nullable=false, length=19)
    public Date getStart() {
        return this.start;
    }
    
    public void setStart(Date start) {
        this.start = start;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end", nullable=false, length=19)
    public Date getEnd() {
        return this.end;
    }
    
    public void setEnd(Date end) {
        this.end = end;
    }

    
    @Column(name="classroom_name", nullable=false)
    public int getClassroomName() {
        return this.classroomName;
    }
    
    public void setClassroomName(int classroomName) {
        this.classroomName = classroomName;
    }




}


