package com.example.universitySE.models;

import com.example.universitySE.domain.Activity;
import com.example.universitySE.domain.StudyCourse;
import com.example.universitySE.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ActivityRateModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private int rate;

    @Getter @Setter
    private Activity activity;

    @Getter @Setter
    private int badge_student;

    @Getter @Setter
    private Subject subject;

    @Getter @Setter
    private StudyCourse studyCourse;

}
