package com.example.universitySE.services;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.intservices.FileSystem;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.ProfessorServiceInterface;
import com.example.universitySE.models.*;
import com.example.universitySE.repositories.*;
import com.example.universitySE.shared.Folder;
import com.example.universitySE.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.IOException;
import java.util.UUID;

@Service
public class ProfessorService implements ProfessorServiceInterface {

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

    @Autowired
    DownloadTeachingMaterialRepository downloadTeachingMaterialRepository;

    @Autowired
    AttendLessonRepository attendLessonRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    StudyCourseRepository studyCourseRepository;

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
            FileSystem directories = new Folder();
            directories.add(file, "/files", subject);
            directories.add(file, "/files/"+id, subject);
            FileSystem filesUp = new FileUp();
            filesUp.add(file, "/files/"+id, subject);
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

    @Override
    public List<RatingTeachingMaterialModel> getAllRateTeachingMaterial() {
        List<RatingTeachingMaterialModel> ratingTeachingMaterialModels = new ArrayList<>();
        List<DownloadTeachingMaterial> downloadTeachingMaterialList = downloadTeachingMaterialRepository.findAll();
        for(int i=0; i<downloadTeachingMaterialList.size(); i++) {
            Optional<TeachingMaterial> teachingMaterialOptional = teachingMaterialRepository.findTeachingMaterialById(downloadTeachingMaterialList.get(i).getIdTeachingMaterial());
            if(teachingMaterialOptional.isPresent()){
                TeachingMaterial teachingMaterial = teachingMaterialOptional.get();
                Optional<Subject> subjectOptional = subjectRepository.findSubjectById(teachingMaterial.getSubject());
                if(subjectOptional.isPresent()){
                    Subject subject = subjectOptional.get();
                    Optional<Professor> professorOptional = professorRepository.findProfessorBySubject(subject.getId());
                    if(professorOptional.isPresent()) {
                        Professor professor = professorOptional.get();
                        int id = downloadTeachingMaterialList.get(i).getId();
                        int feedback_student = downloadTeachingMaterialList.get(i).getFeedbackStudent();
                        int badge_student = downloadTeachingMaterialList.get(i).getBadgeStudent();
                        String note = downloadTeachingMaterialList.get(i).getNote();
                        ratingTeachingMaterialModels.add(new RatingTeachingMaterialModel(id, feedback_student, badge_student, teachingMaterial, note,
                                subject, professor));
                    } else {
                        ratingTeachingMaterialModels.clear();
                    }
                } else {
                    ratingTeachingMaterialModels.clear();
                }
            } else {
                ratingTeachingMaterialModels.clear();
            }
        }
        return ratingTeachingMaterialModels;
    }

    public class FileUp implements FileSystem {

        @Override
        public void add(MultipartFile file, String id, int subject) throws IOException {
            String uniqueID = UUID.randomUUID().toString();
            Path rootLocationFile = Paths.get(Constant.rootLocation+id);
            Path filePath = Paths.get(rootLocationFile+"/"+file.getOriginalFilename());
            File f = new File(String.valueOf(filePath));
            if(f.exists() && !f.isDirectory()) {
                addUploadToDb(subject, id, uniqueID+file.getOriginalFilename());
                Files.copy(file.getInputStream(), rootLocationFile.resolve(uniqueID+file.getOriginalFilename()));
            } else {
                addUploadToDb(subject, id, file.getOriginalFilename());
                Files.copy(file.getInputStream(), rootLocationFile.resolve(file.getOriginalFilename()));
            }
        }

        @Override
        public void remove(MultipartFile file, String id) {

        }

        private void addUploadToDb(int subject, String id, String nameFile) {
            try {
                teachingMaterialRepository.addTeachingMaterial(subject, Constant.pathStore+id+"/"+nameFile);
            } catch (Exception e) {
                log.info("Not added!");
            }

        }
    }

    public List<ActivityRateModel> getAllRateLesson(int id) {
        List<ActivityRateModel> activityRateModelList = new ArrayList<>();
        Optional<Professor> optionalProfessor = professorRepository.findProfessorById(id);
        if(optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            List<AttendLesson> attendLessonList = attendLessonRepository.findAll();
            for (int i=0; i<attendLessonList.size(); i++) {
                Optional<Activity> optionalActivity = activityRepository.findActivityById(attendLessonList.get(i).getIdLesson());
                if(optionalActivity.isPresent()) {
                    Activity activity = optionalActivity.get();
                    if(activity.getSubject() == professor.getSubject()) {
                        Optional<Subject> subjectOptional = subjectRepository.findSubjectById(activity.getSubject());
                        if(subjectOptional.isPresent()) {
                            Subject subject = subjectOptional.get();
                            Optional<StudyCourse> optionalStudyCourse = studyCourseRepository.findStudyCourseById(activity.getStudyCourse());
                            if(optionalStudyCourse.isPresent()) {
                                StudyCourse studyCourse = optionalStudyCourse.get();
                                activityRateModelList.add(new ActivityRateModel(attendLessonList.get(i).getId(),
                                        attendLessonList.get(i).getFeedback(), activity, attendLessonList.get(i).getBadgeStudent(),
                                        subject, studyCourse));
                            }
                        }
                    }
                }
            }
        }
        return activityRateModelList;
    }

}
