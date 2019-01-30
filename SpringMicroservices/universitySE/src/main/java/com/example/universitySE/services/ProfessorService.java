package com.example.universitySE.services;

import com.example.universitySE.domain.Classroom;
import com.example.universitySE.domain.Subject;
import com.example.universitySE.domain.SupportMaterial;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.ProfessorServiceInterface;
import com.example.universitySE.models.SubjectModel;
import com.example.universitySE.repositories.ClassroomRepository;
import com.example.universitySE.repositories.ReportingRepository;
import com.example.universitySE.repositories.SupportMaterialRepository;
import com.example.universitySE.repositories.SubjectRepository;
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
import java.util.List;
import java.util.Optional;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.io.IOException;
import java.util.UUID;

@Service
public class ProfessorService implements ProfessorServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceInterface.class);
    private final Path rootLocation = Paths.get("files");

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SupportMaterialRepository supportMaterialRepository;

    @Autowired
    ReportingRepository reportingRepository;

    @Autowired
    ClassroomRepository classroomRepository;

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
    public void store(MultipartFile file, String id) {
        try {
            String uniqueID = UUID.randomUUID().toString();
            Path rootLocation = Paths.get("files/"+id);
            Path filePath = Paths.get(rootLocation+"/"+file.getOriginalFilename());
            File directory = new File(String.valueOf(rootLocation));
            if (! directory.exists()){
                directory.mkdir();
                File f = new File(String.valueOf(filePath));
                if(f.exists() && !f.isDirectory()) {
                    Files.copy(file.getInputStream(), rootLocation.resolve(uniqueID+file.getOriginalFilename()));
                } else {
                    Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
                }
            } else {
                File f = new File(String.valueOf(filePath));
                if(f.exists() && !f.isDirectory()) {
                    Files.copy(file.getInputStream(), rootLocation.resolve(uniqueID+file.getOriginalFilename()));
                } else {
                    Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
                }
            }
        } catch (Exception e) {
            log.info("Problem loading!");
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
