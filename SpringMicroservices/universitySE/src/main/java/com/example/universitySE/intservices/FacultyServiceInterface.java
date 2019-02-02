package com.example.universitySE.intservices;

import com.example.universitySE.domain.Subject;

import java.util.List;

public interface FacultyServiceInterface {

    List<Subject> getAllSubject();

    List<Integer> getLoggedUserSubject(Integer id, Integer type) throws Exception;

}
