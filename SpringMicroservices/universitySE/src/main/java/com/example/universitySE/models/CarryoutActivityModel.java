package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class CarryoutActivityModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private int idActivity;

    @Getter @Setter
    private int classroomName;
}
