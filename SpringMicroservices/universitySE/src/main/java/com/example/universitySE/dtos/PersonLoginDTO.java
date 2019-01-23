package com.example.universitySE.dtos;

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

