package com.example.universitySE.domain;
// Generated 23-gen-2019 19.26.45 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CarryoutActivity generated by hbm2java
 */
@Entity
@Table(name="Carryout_activity"
    ,catalog="se_database"
)
public class CarryoutActivity  implements java.io.Serializable {


     private int id;
     private int idActivity;
     private int classroomName;

    public CarryoutActivity() {
    }

    public CarryoutActivity(int id, int idActivity, int classroomName) {
       this.id = id;
       this.idActivity = idActivity;
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

    
    @Column(name="id_activity", nullable=false)
    public int getIdActivity() {
        return this.idActivity;
    }
    
    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    
    @Column(name="classroom_name", nullable=false)
    public int getClassroomName() {
        return this.classroomName;
    }
    
    public void setClassroomName(int classroomName) {
        this.classroomName = classroomName;
    }




}


