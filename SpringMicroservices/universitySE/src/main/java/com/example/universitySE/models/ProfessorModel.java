package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
public class ProfessorModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private int person_type;

    @Getter @Setter
    private String firstname;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private String biography;

    @Getter @Setter
    private String receptiontime;

    @Getter @Setter
    private int subject;

    @Getter @Setter
    private Date dateOfBirth;

    public ProfessorModel(long id, String firstName, String lastName, String biography, String receptionTime, int subject, Date dateOfBirth) {
        this.id = id;
        this.firstname = firstName;
        this.lastname = lastName;
        this.biography = biography;
        this.receptiontime = receptionTime;
        this.subject = subject;
        this.dateOfBirth = dateOfBirth;
    }
}
