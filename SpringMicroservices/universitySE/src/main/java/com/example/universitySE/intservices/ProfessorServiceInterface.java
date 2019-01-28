package com.example.universitySE.intservices;

import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.models.SubjectModel;

public interface ProfessorServiceInterface {

    SubjectModel getSubject(int id) throws SubjectException;

}
