package com.example.universitySE.models;

import com.example.universitySE.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class TeachingMaterialModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private Subject subject;

    @Getter @Setter
    private String media;

}
