package com.example.universitySE.intservices;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileSystem {

    public void add(MultipartFile file, String id, int subject) throws IOException;

    public void remove(MultipartFile file, String id);

}
