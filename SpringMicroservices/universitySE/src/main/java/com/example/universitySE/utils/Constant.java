package com.example.universitySE.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {

    public static final int SECRETARY = 1;
    public static final int PROFESSOR = 2;
    public static final int STUDENT = 3;

    public final static Path rootLocation = Paths.get("src/main/resources/static");
    public static final String pathStore = "http://localhost:8090";
}
