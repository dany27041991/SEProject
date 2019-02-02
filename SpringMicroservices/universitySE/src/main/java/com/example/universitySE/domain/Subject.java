package com.example.universitySE.domain;
// Generated 2-feb-2019 18.45.35 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subject generated by hbm2java
 */
@Entity
@Table(name="Subject"
    ,catalog="se_database"
)
public class Subject  implements java.io.Serializable {


     private Integer id;
     private String name;
     private int studyCourse;
     private int yearCourse;

    public Subject() {
    }

    public Subject(String name, int studyCourse, int yearCourse) {
       this.name = name;
       this.studyCourse = studyCourse;
       this.yearCourse = yearCourse;
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

    
    @Column(name="study_course", nullable=false)
    public int getStudyCourse() {
        return this.studyCourse;
    }
    
    public void setStudyCourse(int studyCourse) {
        this.studyCourse = studyCourse;
    }

    
    @Column(name="year_course", nullable=false)
    public int getYearCourse() {
        return this.yearCourse;
    }
    
    public void setYearCourse(int yearCourse) {
        this.yearCourse = yearCourse;
    }




}


