package com.example.universitySE.shared;

import com.example.universitySE.intservices.FileSystem;
import com.example.universitySE.utils.Constant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder implements FileSystem {

    @Override
    public void add(MultipartFile file, String id, int subject) {
        File directory = new File(String.valueOf(Constant.rootLocation+id));
        if (! directory.exists()){
            directory.mkdir();
        }
    }

    @Override
    public void remove(MultipartFile file, String id) {

    }
}
