package com.example.universitySE.models;

import com.example.universitySE.domain.Professor;
import com.example.universitySE.domain.Subject;
import com.example.universitySE.domain.TeachingMaterial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class RatingTeachingMaterialModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private int feedback_student;

    @Getter @Setter
    private int badge_student;

    @Getter @Setter
    private TeachingMaterial teachingMaterial;

    @Getter @Setter
    private String note;

    @Getter @Setter
    private Subject subject;

    @Getter @Setter
    private Professor professor;

}
