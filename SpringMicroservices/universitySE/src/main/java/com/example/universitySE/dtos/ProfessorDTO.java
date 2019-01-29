package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ProfessorDTO {

    @Getter @Setter
    private int id;

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
}
