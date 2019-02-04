package com.example.universitySE.services;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.ProfessorServiceInterface;
import com.example.universitySE.models.ReportingModel;
import com.example.universitySE.models.SubjectModel;
import com.example.universitySE.models.TeachingMaterialModel;
import com.example.universitySE.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.core.io.UrlResource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.io.IOException;
import java.util.UUID;

@Service
public class ProfessorService implements ProfessorServiceInterface {

    private static final String pathStore = "http://localhost:8090/files/";
    private static final Logger log = LoggerFactory.getLogger(LoginServiceInterface.class);

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SupportMaterialRepository supportMaterialRepository;

    @Autowired
    ReportingRepository reportingRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    SecretaryRepository secretaryRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    TeachingMaterialRepository teachingMaterialRepository;

    @Autowired
    StudentRepository studentRepository;

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

    @Override
    public void addReporting(ReportingDTO reportingDTO) {
        reportingRepository.addReporting(reportingDTO.getNote_prof(), reportingDTO.getSupport_material(),
                reportingDTO.getState(), reportingDTO.getId_prof(), reportingDTO.getId_classroom());
    }

    @Override
    public List<Classroom> getClassroom() throws ClassroomException {
        List<Classroom> classrooms = classroomRepository.findAll();
        if(!classrooms.isEmpty()) {
            log.info("Classroom is present!");
            return classrooms;
        } else {
            log.info("Classroom is not present!");
            throw new ClassroomException("Classroom is not present!");
        }
    }

    @Override
    public List<ReportingModel> getAllReporting() {
        List<ReportingModel> reportingModelList = new ArrayList<>();
        List<Reporting> reportings = reportingRepository.findAll();
        for(int i = 0; i<reportings.size(); i++) {
            List<SupportMaterial> supportMaterials = supportMaterialRepository.findAll();

            List<Secretary> secretaries = secretaryRepository.findAll();

            Optional<Classroom> optionalClassroom = classroomRepository.findClassroomById(reportings.get(i).getIdClassroom());
            Classroom classroom;
            if(optionalClassroom.isPresent()) {
                classroom = optionalClassroom.get();
            } else {
                classroom = null;
            }

            Optional<Professor> optionalProfessor = professorRepository.findProfessorById(reportings.get(i).getIdProf());
            Professor professor;
            if(optionalProfessor.isPresent()) {
                professor = optionalProfessor.get();
            } else {
                professor = null;
            }
            reportingModelList.add(new ReportingModel(reportings.get(i).getId(), reportings.get(i).getNoteProf(), supportMaterials,
                    reportings.get(i).getNoteSec(), reportings.get(i).getState(), professor, secretaries, classroom));
        }
        return reportingModelList;
    }


    @Override
    public void store(MultipartFile file, String id, int subject) {
        try {
            String uniqueID = UUID.randomUUID().toString();
            Path rootLocation = Paths.get("src/main/resources/static/files/"+id);
            Path filePath = Paths.get(rootLocation+"/"+file.getOriginalFilename());
            File directory = new File(String.valueOf(rootLocation));
            if (! directory.exists()){
                directory.mkdir();
                File f = new File(String.valueOf(filePath));
                if(f.exists() && !f.isDirectory()) {
                    teachingMaterialRepository.addTeachingMaterial(subject, pathStore+id+"/"+uniqueID+file.getOriginalFilename());
                    Files.copy(file.getInputStream(), rootLocation.resolve(uniqueID+file.getOriginalFilename()));
                } else {
                    teachingMaterialRepository.addTeachingMaterial(subject, pathStore+id+"/"+file.getOriginalFilename());
                    Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
                }
            } else {
                File f = new File(String.valueOf(filePath));
                if(f.exists() && !f.isDirectory()) {
                    teachingMaterialRepository.addTeachingMaterial(subject, pathStore+id+"/"+uniqueID+file.getOriginalFilename());
                    Files.copy(file.getInputStream(), rootLocation.resolve(uniqueID+file.getOriginalFilename()));
                } else {
                    teachingMaterialRepository.addTeachingMaterial(subject, pathStore+id+"/"+file.getOriginalFilename());
                    Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
                }
            }
        } catch (Exception e) {
            log.info("Problem loading!");
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public List<TeachingMaterialModel> getAllTeachingMaterialForStudent(int id) {
        List<TeachingMaterialModel> teachingMaterialModels = new ArrayList<>();
        Optional<Student> optionalStudent = studentRepository.findStudentById(id);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<Subject> subjectList = subjectRepository.findSubjectByStudyCourse(student.getStudyCourse());
            for(int i=0; i<subjectList.size(); i++){
                List<TeachingMaterial> materials = teachingMaterialRepository.getTeachingMaterialBySubject(subjectList.get(i).getId());
                for(int k=0; k<materials.size(); k++){
                    teachingMaterialModels.add(new TeachingMaterialModel(materials.get(k).getId(), subjectList.get(i),
                            materials.get(k).getMedia()));
                }
            }
        }
        return teachingMaterialModels;
    }


}
