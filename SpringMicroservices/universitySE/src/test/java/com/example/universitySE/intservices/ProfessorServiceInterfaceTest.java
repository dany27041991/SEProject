package com.example.universitySE.intservices;

import com.example.universitySE.domain.Classroom;
import com.example.universitySE.domain.SupportMaterial;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.models.ReportingModel;
import com.example.universitySE.models.SubjectModel;
import com.example.universitySE.models.TeachingMaterialModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfessorServiceInterfaceTest {

    @Mock
    ProfessorServiceInterface professorServiceInterfaces = mock(ProfessorServiceInterface.class);

    @Test
    public void getSubject() throws SubjectException {
        SubjectModel subjectModel = mock(SubjectModel.class);
        subjectModel.setId(1);
        subjectModel.setName("test");
        subjectModel.setStudy_course(1);
        subjectModel.setYear_course(1);
        when(professorServiceInterfaces.getSubject(1)).thenReturn(subjectModel);

        SubjectModel subj = professorServiceInterfaces.getSubject(1);
        assertEquals(subj, subjectModel);
    }

    @Test
    public void getMaterial() throws MaterialException {
        SupportMaterial supportMaterial = mock(SupportMaterial.class);
        List<SupportMaterial> supportMaterials = new ArrayList<>();
        supportMaterials.add(supportMaterial);
        when(professorServiceInterfaces.getMaterial()).thenReturn(supportMaterials);

        List<SupportMaterial> materialList = professorServiceInterfaces.getMaterial();
        assertEquals(materialList, supportMaterials);
    }

    @Test
    public void addReporting() {
        ReportingDTO reportingDTO = mock(ReportingDTO.class);
        professorServiceInterfaces.addReporting(reportingDTO);
    }

    @Test
    public void getClassroom() throws ClassroomException {
        Classroom classroom = mock(Classroom.class);
        classroom.setId(1);
        classroom.setLatitude(new BigDecimal(1));
        classroom.setLongitude(new BigDecimal(1));
        classroom.setName("test");
        List<Classroom> classroomList = new ArrayList<>();
        classroomList.add(classroom);
        when(professorServiceInterfaces.getClassroom()).thenReturn(classroomList);

        List<Classroom> classrooms = professorServiceInterfaces.getClassroom();
        assertEquals(classrooms.get(0).getId(), classroom.getId());
    }

    @Test
    public void getAllReporting() {
        ReportingModel reportingModel = mock(ReportingModel.class);
        List<ReportingModel> reportingModelList = new ArrayList<>();
        reportingModelList.add(reportingModel);
        when(professorServiceInterfaces.getAllReporting()).thenReturn(reportingModelList);

        List<ReportingModel> reportingModels = professorServiceInterfaces.getAllReporting();
        assertEquals(reportingModels.get(0).getClassrooms(), reportingModelList.get(0).getClassrooms());
    }

    @Test
    public void store() {
        MultipartFile multipartFile = mock(MultipartFile.class);
        professorServiceInterfaces.store(multipartFile, "1",1);
    }

    @Test
    public void getAllTeachingMaterialForStudent() {
        TeachingMaterialModel materialModel = mock(TeachingMaterialModel.class);
        List<TeachingMaterialModel> materialModelList = new ArrayList<>();
        materialModelList.add(materialModel);
        when(professorServiceInterfaces.getAllTeachingMaterialForStudent(19)).thenReturn(materialModelList);

        List<TeachingMaterialModel> materialModels = professorServiceInterfaces.getAllTeachingMaterialForStudent(19);
        assertEquals(materialModels, materialModelList);
    }
}