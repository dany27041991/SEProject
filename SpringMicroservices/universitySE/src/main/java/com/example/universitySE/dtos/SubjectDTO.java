package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class SubjectDTO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int studyCourse;

    @Getter @Setter
    private int yearCourse;

    @Getter @Setter
    private List<Integer> subjects;
}