package com.example.universitySE.services;

import com.example.universitySE.domain.Subject;
import com.example.universitySE.domain.SupportMaterial;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.ProfessorServiceInterface;
import com.example.universitySE.models.SubjectModel;
import com.example.universitySE.repositories.SupportMaterialRepository;
import com.example.universitySE.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements ProfessorServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceInterface.class);

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SupportMaterialRepository supportMaterialRepository;

    @Override
    public SubjectModel getSubject(int id) throws SubjectException {
        Optional<Subject> subject = subjectRepository.findSubjectById(id);
        if(subject.isPresent()) {
            log.info("Subject exists!");
            Subject subjectGetted = subject.get();
            SubjectModel subjectModel = new SubjectModel(subjectGetted.getId(),subjectGetted.getName(),
                    subjectGetted.getStudyCourse(), subjectGetted.getYearCourse());
            return subjectModel;
        } else {
            log.info("Subject not exist!");
            throw new SubjectException("Subject Not Found!");
        }
    }

    @Override
    public List<SupportMaterial> getMaterial() throws MaterialException {
        List<SupportMaterial> supportMaterials = supportMaterialRepository.findAll();
        if(!supportMaterials.isEmpty()) {
            log.info("Support material is present!");
            return supportMaterials;
        } else {
            log.info("Support material is not present!");
            throw new MaterialException("Support material is not present!");
        }
    }
}
