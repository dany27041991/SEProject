package com.example.universitySE.intservices;

import com.example.universitySE.domain.SupportMaterial;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.models.SubjectModel;

import java.util.List;

public interface ProfessorServiceInterface {

    SubjectModel getSubject(int id) throws SubjectException;

    List<SupportMaterial> getMaterial() throws MaterialException;

}
