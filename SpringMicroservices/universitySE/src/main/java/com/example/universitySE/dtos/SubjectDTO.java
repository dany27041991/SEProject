package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class SubjectDTO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int studyCourse;

    @Getter @Setter
    private int yearCourse;
}
