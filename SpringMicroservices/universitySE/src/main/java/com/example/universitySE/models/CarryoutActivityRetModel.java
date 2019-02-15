package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class CarryoutActivityRetModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private StudyCourseModel studyCourseModel;

    @Getter @Setter
    private SubjectCalendarModel subjectCalendarModel;

    @Getter @Setter
    private ProfessorCalendarModel professorCalendarModel;

    @Getter @Setter
    private String start;

    @Getter @Setter
    private String end;

    @Getter @Setter
    private ActivityCalendarModel activityCalendarModel;

    @Getter @Setter
    private ClassroomModel classroomModel;
}
