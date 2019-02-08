package com.example.universitySE.domain;
// Generated 2-feb-2019 18.39.07 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;
import java.util.Date;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name="Student"
    ,catalog="se_database"
    , uniqueConstraints = @UniqueConstraint(columnNames="badge_number") 
)
public class Student  implements java.io.Serializable {


     private long id;
     private String firstName;
     private String lastName;
     private Date dateOfBirth;
     private long badgeNumber;
     private int studyCourse;
     private Date enrollmentYear;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, Date dateOfBirth, long badgeNumber, int studyCourse, Date enrollmentYear) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.dateOfBirth = dateOfBirth;
       this.badgeNumber = badgeNumber;
       this.studyCourse = studyCourse;
       this.enrollmentYear = enrollmentYear;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
    @Column(name="first_name", nullable=false)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", nullable=false)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth", nullable=false, length=10)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    @Column(name="badge_number", unique=true, nullable=false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBadgeNumber() {
        return this.badgeNumber;
    }
    
    public void setBadgeNumber(long badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    
    @Column(name="study_course", nullable=false)
    public int getStudyCourse() {
        return this.studyCourse;
    }
    
    public void setStudyCourse(int studyCourse) {
        this.studyCourse = studyCourse;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="enrollment_year", nullable=false, length=10)
    public Date getEnrollmentYear() {
        return this.enrollmentYear;
    }
    
    public void setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }




}


