package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class StudentModel {

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
    private java.util.Date birthdate;

    @Getter @Setter
    private long badgenumber;

    @Getter @Setter
    private int studycourse;

    @Getter @Setter
    private java.util.Date enrollmentyear;


}
