package com.example.universitySE.domain;
// Generated 2-feb-2019 18.45.35 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PersonType generated by hbm2java
 */
@Entity
@Table(name="Person_type"
    ,catalog="se_database"
)
public class PersonType  implements java.io.Serializable {


     private Integer id;
     private String name;

    public PersonType() {
    }

    public PersonType(String name) {
       this.name = name;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


