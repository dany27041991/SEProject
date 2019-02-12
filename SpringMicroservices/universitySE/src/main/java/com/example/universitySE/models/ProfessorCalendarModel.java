package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ProfessorCalendarModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String firstname;

    @Getter @Setter
    private String lastname;
}
