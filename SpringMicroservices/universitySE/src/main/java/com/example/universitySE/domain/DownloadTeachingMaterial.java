package com.example.universitySE.domain;
<<<<<<< HEAD
// Generated 28-gen-2019 15.27.48 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
=======
// Generated 29-gen-2019 8.53.01 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> master

/**
 * DownloadTeachingMaterial generated by hbm2java
 */
@Entity
@Table(name="Download_teaching_material"
    ,catalog="se_database"
)
public class DownloadTeachingMaterial  implements java.io.Serializable {


     private int id;
     private int feedbackStudent;
     private int badgeStudent;
     private int idTeachingMaterial;

    public DownloadTeachingMaterial() {
    }

    public DownloadTeachingMaterial(int id, int feedbackStudent, int badgeStudent, int idTeachingMaterial) {
       this.id = id;
       this.feedbackStudent = feedbackStudent;
       this.badgeStudent = badgeStudent;
       this.idTeachingMaterial = idTeachingMaterial;
    }
   
<<<<<<< HEAD
     @Id
=======
     @Id 
>>>>>>> master

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
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




}


