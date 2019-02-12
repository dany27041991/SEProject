package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class StudyCourseModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private FacultyModel faculty;
}
