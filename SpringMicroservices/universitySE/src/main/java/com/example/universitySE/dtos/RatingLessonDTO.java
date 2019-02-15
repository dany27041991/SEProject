package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class RatingLessonDTO {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private int rate;

    @Getter @Setter
    private int id_student;

}
