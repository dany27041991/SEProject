package com.example.universitySE.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class SecretaryDTO {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private int faculty;

    @Getter @Setter
    private String venue;
}
