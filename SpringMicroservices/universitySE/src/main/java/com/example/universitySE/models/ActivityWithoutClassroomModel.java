package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ActivityWithoutClassroomModel {

    @Getter @Setter
    private long id;

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
}
