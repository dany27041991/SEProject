package com.example.universitySE.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class JSONResponseBody {

    @Getter @Setter
    private int server;

    @Getter @Setter
    private Object response;
}
