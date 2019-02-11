package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class SecretaryRetModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private FacultyModel faculty;

    @Getter @Setter
    private String venue;
}
