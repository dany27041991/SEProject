package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor @NoArgsConstructor
public class PersonModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private int idstudent;

    @Getter @Setter
    private String firstnamestudent;

    @Getter @Setter
    private String lastnamestudent;

    @Getter @Setter
    private Date birthdatestudent;

    @Getter @Setter
    private int badgenumberstudent;

    @Getter @Setter
    private int studycoursestudent;

    @Getter @Setter
    private Date enrollmentyearstudent;

    @Getter @Setter
    private int idprofessor;

    @Getter @Setter
    private String firstnameprofessor;

    @Getter @Setter
    private String lastnameprofessor;

    @Getter @Setter
    private String biographyprofessor;

    @Getter @Setter
    private String receptiontime;

    @Getter @Setter
    private int subjectprofessor;

}
