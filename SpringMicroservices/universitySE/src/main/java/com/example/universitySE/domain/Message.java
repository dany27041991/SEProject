package com.example.universitySE.domain;
// Generated 2-feb-2019 18.45.35 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message generated by hbm2java
 */
@Entity
@Table(name="Message"
    ,catalog="se_database"
)
public class Message  implements java.io.Serializable {


     private Integer id;
     private String content;
     private int subject;

    public Message() {
    }

    public Message(String content, int subject) {
       this.content = content;
       this.subject = subject;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="content", nullable=false)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    
    @Column(name="subject", nullable=false)
    public int getSubject() {
        return this.subject;
    }
    
    public void setSubject(int subject) {
        this.subject = subject;
    }




}


