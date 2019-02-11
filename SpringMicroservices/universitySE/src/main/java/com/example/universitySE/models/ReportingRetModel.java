package com.example.universitySE.models;

import com.example.universitySE.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ReportingRetModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String noteProf;

    @Getter @Setter
    private SupportMaterialModel supportMaterial;

    @Getter @Setter
    private String noteSec;

    @Getter @Setter
    private StateModel state;

    @Getter @Setter
    private ProfessorModel professor;

    @Getter @Setter
    private SecretaryRetModel secretary;

    @Getter @Setter
    private ClassroomModel classroom;

    public ReportingRetModel(long id, String noteProf, SupportMaterialModel supportMaterial, StateModel state, ProfessorModel professor, ClassroomModel classroom) {
        this.id = id;
        this.noteProf = noteProf;
        this.supportMaterial = supportMaterial;
        this.state = state;
        this.professor = professor;
        this.classroom = classroom;
    }
}
