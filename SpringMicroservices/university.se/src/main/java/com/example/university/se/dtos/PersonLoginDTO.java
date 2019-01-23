package com.example.university.se.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class PersonLoginDTO {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
