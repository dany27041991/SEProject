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
 * Secretary generated by hbm2java
 */
@Entity
@Table(name="Secretary"
    ,catalog="se_database"
)
public class Secretary  implements java.io.Serializable {


     private int id;
     private int faculty;
     private String venue;

    public Secretary() {
    }

    public Secretary(int id, int faculty, String venue) {
       this.id = id;
       this.faculty = faculty;
       this.venue = venue;
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

    
    @Column(name="faculty", nullable=false)
    public int getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    
    @Column(name="venue", nullable=false)
    public String getVenue() {
        return this.venue;
    }
    
    public void setVenue(String venue) {
        this.venue = venue;
    }




}


