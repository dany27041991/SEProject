package com.example.universitySE.intservices;

import com.example.universitySE.domain.Classroom;
import com.example.universitySE.domain.SupportMaterial;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.models.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfessorServiceInterface {

    SubjectModel getSubject(int id) throws SubjectException;

    List<SupportMaterial> getMaterial() throws MaterialException;

    void addReporting(ReportingDTO reportingDTO);

    List<Classroom> getClassroom() throws ClassroomException;

    List<ReportingModel> getAllReporting();

    void store(MultipartFile file, String id, int subject);

    List<TeachingMaterialModel> getAllTeachingMaterialForStudent(int id);

    List<RatingTeachingMaterialModel> getAllRateTeachingMaterial();

    List<ActivityRateModel> getAllRateLesson(int id);
}
