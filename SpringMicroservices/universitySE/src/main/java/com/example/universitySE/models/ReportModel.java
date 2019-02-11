package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ReportModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String noteProf;

    @Getter @Setter
    private int supportMaterial;

    @Getter @Setter
    private String noteSec;

    @Getter @Setter
    private int state;

    @Getter @Setter
    private int professor;

    @Getter @Setter
    private Integer secretary;

    @Getter @Setter
    private int classroom;
}
