package com.example.universitySE.intservices;

import com.example.universitySE.domain.Student;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.models.TeachingMaterialModel;
import com.example.universitySE.repositories.*;
import com.example.universitySE.services.ProfessorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfessorServiceInterfaceTest {

    @InjectMocks
    ProfessorService professorService;

    @Mock
    SubjectRepository subjectRepository;

    @Mock
    SupportMaterialRepository supportMaterialRepository;

    @Mock
    ReportingRepository reportingRepository;

    @Mock
    ClassroomRepository classroomRepository;

    @Mock
    SecretaryRepository secretaryRepository;

    @Mock
    ProfessorRepository professorRepository;

    @Mock
    TeachingMaterialRepository teachingMaterialRepository;

    @Mock
    StudentRepository studentRepository;

    @Test
    public void getSubject() throws SubjectException {
        //professorService.getSubject(1);
        subjectRepository.findSubjectById(1);
    }

    @Test
    public void getMaterial() throws MaterialException {
        //professorService.getMaterial();
        supportMaterialRepository.findAll();
    }

    @Test
    public void addReporting() {
        ReportingDTO reportingDTO = mock(ReportingDTO.class);
        professorService.addReporting(reportingDTO);
        reportingRepository.addReporting("test", 1, 1, 9, 1);
    }

    @Test
    public void getClassroom() throws ClassroomException {
        //professorService.getClassroom();
        classroomRepository.findAll();
    }

    @Test
    public void getAllReporting() {
        professorService.getAllReporting();
        secretaryRepository.findAll();
        reportingRepository.findAll();
        classroomRepository.findClassroomById(1);
        professorRepository.findProfessorById(9);
    }

    /*@Test
    public void store() { }*/

    @Test
    public void getAllTeachingMaterialForStudent() {
        TeachingMaterialModel materialModel = mock(TeachingMaterialModel.class);
        List<TeachingMaterialModel> materialModelList = new ArrayList<>();
        materialModelList.add(materialModel);
        when(professorService.getAllTeachingMaterialForStudent(19)).thenReturn(materialModelList);
        subjectRepository.findSubjectByStudyCourse(1);
        teachingMaterialRepository.getTeachingMaterialBySubject(1);
    }
}