package com.example.universitySE.models;

import com.example.universitySE.domain.Classroom;
import com.example.universitySE.domain.Professor;
import com.example.universitySE.domain.Secretary;
import com.example.universitySE.domain.SupportMaterial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class ReportingModel {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String noteProf;

    @Getter @Setter
    private List<SupportMaterial> supportMaterials;

    @Getter @Setter
    private String noteSec;

    @Getter @Setter
    private int state;

    @Getter @Setter
    private Professor professors;

    @Getter @Setter
    private List<Secretary> secretaries;

    @Getter @Setter
    private Classroom classrooms;

}
