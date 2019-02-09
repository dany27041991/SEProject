package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class MobilePersonModel {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private int person_type;

    @Getter @Setter
    private String firstname;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private java.util.Date birthdate;

}
