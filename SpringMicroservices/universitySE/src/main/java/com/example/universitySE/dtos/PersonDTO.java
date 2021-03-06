package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
public class PersonDTO {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private int personType;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String biography;

    @Getter @Setter
    private String receptionTime;

    @Getter @Setter
    private int subject;

    @Getter @Setter
    private Date dateOfBirth;

    @Getter @Setter
    private int badgeNumber;

    @Getter @Setter
    private int studyCourse;

    @Getter @Setter
    private Date enrollmentYear;

}
