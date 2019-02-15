package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
public class CarryoutActivityCalendarModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private StudyCourseModel studyCourseModel;

    @Getter @Setter
    private SubjectCalendarModel subjectCalendarModel;

    @Getter @Setter
    private ProfessorCalendarModel professorCalendarModel;

    @Getter @Setter
    private Date start;

    @Getter @Setter
    private Date end;

    @Getter @Setter
    private ActivityCalendarModel activityCalendarModel;

    @Getter @Setter
    private ClassroomModel classroomModel;
}
