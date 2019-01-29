package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
public class ActivityDTO {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private int studyCourse;

    @Getter @Setter
    private int subject;

    @Getter @Setter
    private int idProf;

    @Getter @Setter
    private Date start;

    @Getter @Setter
    private Date end;

    @Getter @Setter
    private int classroomName;

    @Getter @Setter
    private int activityType;
}
