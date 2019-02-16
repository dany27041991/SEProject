package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
public class StudentModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private int person_type;

    @Getter @Setter
    private String firstname;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private java.util.Date birthdate;

    @Getter @Setter
    private int badgenumber;

    @Getter @Setter
    private int studycourse;

    @Getter @Setter
    private java.util.Date enrollmentyear;

    public StudentModel(int id, String firstname, String lastname, Date birthdate, int badgenumber, int studycourse,
                        Date enrollmentyear) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.badgenumber = badgenumber;
        this.studycourse = studycourse;
        this.enrollmentyear = enrollmentyear;
    }


}
