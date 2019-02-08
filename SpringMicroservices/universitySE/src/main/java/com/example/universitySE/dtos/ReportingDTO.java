package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ReportingDTO {

    @Getter @Setter
    private String note_prof;

    @Getter @Setter
    private int support_material;

    @Getter @Setter
    private int state;

    @Getter @Setter
    private int id_prof;

    @Getter @Setter
    private int id_classroom;
}
