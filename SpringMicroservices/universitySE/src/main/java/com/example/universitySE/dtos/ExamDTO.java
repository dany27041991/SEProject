package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
public class ExamDTO {

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
    private int activityType;

    @Getter @Setter
    private int id;
}
