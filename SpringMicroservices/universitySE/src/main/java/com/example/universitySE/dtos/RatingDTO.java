package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class RatingDTO {

    @Getter @Setter
    private int id_student;

    @Getter @Setter
    private int feedback_student;

    @Getter @Setter
    private int id_teaching_material;

    @Getter @Setter
    private String note;

}
