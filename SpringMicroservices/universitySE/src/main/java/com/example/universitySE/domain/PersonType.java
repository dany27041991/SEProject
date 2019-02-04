package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.13 by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

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


