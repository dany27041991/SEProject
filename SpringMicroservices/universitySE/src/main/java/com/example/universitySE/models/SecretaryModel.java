package com.example.universitySE.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class SecretaryModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private int person_type;

    @Getter @Setter
    private int faculty;

    @Getter @Setter
    private String venue;
}
