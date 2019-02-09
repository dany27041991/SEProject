package com.example.universitySE.domain;
// Generated 8-feb-2019 18.41.41 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * DownloadTeachingMaterial generated by hbm2java
 */
@Entity
@Table(name="Download_teaching_material"
    ,catalog="se_database"
)
public class DownloadTeachingMaterial  implements java.io.Serializable {


     private Integer id;
     private int feedbackStudent;
     private int badgeStudent;
     private int idTeachingMaterial;
     private String note;

    public DownloadTeachingMaterial() {
    }

    public DownloadTeachingMaterial(int feedbackStudent, int badgeStudent, int idTeachingMaterial, String note) {
       this.feedbackStudent = feedbackStudent;
       this.badgeStudent = badgeStudent;
       this.idTeachingMaterial = idTeachingMaterial;
       this.note = note;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="feedback_student", nullable=false)
    public int getFeedbackStudent() {
        return this.feedbackStudent;
    }
    
    public void setFeedbackStudent(int feedbackStudent) {
        this.feedbackStudent = feedbackStudent;
    }

    
    @Column(name="badge_student", nullable=false)
    public int getBadgeStudent() {
        return this.badgeStudent;
    }
    
    public void setBadgeStudent(int badgeStudent) {
        this.badgeStudent = badgeStudent;
    }

    
    @Column(name="id_teaching_material", nullable=false)
    public int getIdTeachingMaterial() {
        return this.idTeachingMaterial;
    }
    
    public void setIdTeachingMaterial(int idTeachingMaterial) {
        this.idTeachingMaterial = idTeachingMaterial;
    }

    
    @Column(name="note", nullable=false)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }




}


