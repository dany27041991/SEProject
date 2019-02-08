package com.example.universitySE.services;

import com.example.universitySE.domain.Subject;
import com.example.universitySE.domain.TeachingMaterial;
import com.example.universitySE.dtos.RatingDTO;
import com.example.universitySE.intservices.StudentServiceInterface;
import com.example.universitySE.models.LastUploadModel;
import com.example.universitySE.repositories.DownloadTeachingMaterialRepository;
import com.example.universitySE.repositories.SubjectRepository;
import com.example.universitySE.repositories.TeachingMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface{

    @Autowired
    DownloadTeachingMaterialRepository downloadTeachingMaterialRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeachingMaterialRepository teachingMaterialRepository;


    @Override
    public void addRating(RatingDTO ratingDTO) {
        downloadTeachingMaterialRepository.addReporting(ratingDTO.getFeedback_student(), ratingDTO.getId_student(),
                ratingDTO.getId_teaching_material(), ratingDTO.getNote());
    }

    @Override
    public List<LastUploadModel> getLastUpload(List<Integer> subjects) {
        List<LastUploadModel> lastUploadModels = new ArrayList<>();
        for (int i=0; i<subjects.size(); i++) {
            Subject subject;
            Optional<Subject> optionalSubject = subjectRepository.findSubjectById(subjects.get(i));
            if(optionalSubject.isPresent()) {
                subject = optionalSubject.get();
            } else return null;
            List<TeachingMaterial> teachingMaterials = teachingMaterialRepository.getTeachingMaterialBySubject(subjects.get(i));
            if(teachingMaterials.size()>0) {
                lastUploadModels.add(new LastUploadModel(teachingMaterials.get(teachingMaterials.size()-1).getId(),
                        subject, teachingMaterials.get(teachingMaterials.size()-1).getMedia()));
            }
        }
        return lastUploadModels;
    }
}
