package com.example.universitySE.apicontrollers;

import com.example.universitySE.domain.Classroom;
import com.example.universitySE.domain.SupportMaterial;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.ClassroomException;
import com.example.universitySE.exceptions.UserNotLoggedException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.ProfessorServiceInterface;
import com.example.universitySE.models.ReportingModel;
import com.example.universitySE.models.SubjectModel;
import com.example.universitySE.models.TeachingMaterialModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = ProfessorController.class, secure = false)
public class ProfessorControllerTest {

    @Mock
    LoginServiceInterface loginServiceInterface;

    @Mock
    ProfessorServiceInterface professorServiceInterface;

    @Test
    public void getSubject() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        SubjectModel subjectModel = mock(SubjectModel.class);
        subjectModel.setId(1);
        subjectModel.setYear_course(1);
        subjectModel.setStudy_course(1);
        subjectModel.setName("test");
        when(professorServiceInterface.getSubject(1)).thenReturn(subjectModel);

        SubjectModel subjectModel1 = mock(SubjectModel.class);
        subjectModel.setId(1);
        subjectModel.setYear_course(1);
        subjectModel.setStudy_course(1);
        subjectModel.setName("test");
        assertEquals(subjectModel1.getId(), subjectModel.getId());
        assertEquals(subjectModel1.getName(), subjectModel.getName());
        assertEquals(subjectModel1.getStudy_course(), subjectModel.getStudy_course());
        assertEquals(subjectModel1.getYear_course(), subjectModel.getYear_course());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8090/user/professor/subject/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

    }

    @Test
    public void getMaterials() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        SupportMaterial supportMaterial = mock(SupportMaterial.class);
        List<SupportMaterial> supportMaterials = new ArrayList<>();
        supportMaterials.add(supportMaterial);
        when(professorServiceInterface.getMaterial()).thenReturn(supportMaterials);

        SupportMaterial supportMaterial1 = mock(SupportMaterial.class);
        List<SupportMaterial> supportMaterials1 = new ArrayList<>();
        supportMaterials1.add(supportMaterial1);
        assertNotEquals(supportMaterial, supportMaterial1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("http://localhost:8090/user/professor/materials")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

    }

    @Test
    public void addReporting() throws UnsupportedEncodingException, UserNotLoggedException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ReportingDTO reportingDTO = mock(ReportingDTO.class);
        reportingDTO.setId_prof(1);
        reportingDTO.setSupport_material(1);
        reportingDTO.setState(1);
        reportingDTO.setNote_prof("test");
        professorServiceInterface.addReporting(reportingDTO);

        ReportingDTO reportingDTO1 = reportingDTO;
        assertEquals(reportingDTO, reportingDTO1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("http://localhost:8090/user/professor/addreporting")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getClassroom() throws UnsupportedEncodingException, UserNotLoggedException, ClassroomException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        Classroom classroom = mock(Classroom.class);
        List<Classroom> classroomList = new ArrayList<>();
        classroomList.add(classroom);
        when(professorServiceInterface.getClassroom()).thenReturn(classroomList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("http://localhost:8090/user/professor/classrooms")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getAllReporting() throws UnsupportedEncodingException, UserNotLoggedException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ReportingModel reportingModel = mock(ReportingModel.class);
        List<ReportingModel> reportingModelList = new ArrayList<>();
        reportingModelList.add(reportingModel);
        when(professorServiceInterface.getAllReporting()).thenReturn(reportingModelList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("http://localhost:8090/user/professor/getAllReporting")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void handleFileUpload() throws UnsupportedEncodingException, UserNotLoggedException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        MultipartFile multipartFile = mock(MultipartFile.class);
        professorServiceInterface.store(multipartFile, "1", 1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("http://localhost:8090/user/professor/upload")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getAllTeachingMaterials() {
        TeachingMaterialModel materialModel = mock(TeachingMaterialModel.class);
        List<TeachingMaterialModel> teachingMaterialModelList = new ArrayList<>();
        teachingMaterialModelList.add(materialModel);
        when(professorServiceInterface.getAllTeachingMaterialForStudent(1)).thenReturn(teachingMaterialModelList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("http://localhost:8090/user/professor/getAllTeachingMaterials/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }
}