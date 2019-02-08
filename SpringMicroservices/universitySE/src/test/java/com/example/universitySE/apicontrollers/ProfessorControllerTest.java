package com.example.universitySE.apicontrollers;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.PersonLoginDTO;
import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.exceptions.UserNotLoggedException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.models.ReportingModel;
import com.example.universitySE.models.SubjectModel;
import com.example.universitySE.models.TeachingMaterialModel;
import com.example.universitySE.services.ProfessorService;
import com.example.universitySE.utils.JwtUtils;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = ProfessorController.class, secure = false)
public class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginServiceInterface loginServiceInterface;

    @MockBean
    ProfessorService professorService;

    /*@Test
    public void getSubject() throws Exception {
        HttpServletRequest httpServletRequest = null;
        Map<String, Object> userData = JwtUtils.jwt2Map("fad32rfwej8i");
        Mockito.when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest))
                .thenReturn(userData);

        SubjectModel supportMaterials = new SubjectModel(1, "test", 1, 1);
        Mockito.when(professorService.getSubject(1))
                .thenReturn(supportMaterials);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("user/professor/subject/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);

    }

    @Test
    public void getMaterials() throws Exception {
        HttpServletRequest httpServletRequest = null;
        Map<String, Object> userData = JwtUtils.jwt2Map("fad32rfwej8i");
        Mockito.when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest))
                .thenReturn(userData);

        SupportMaterial studentModel = new SupportMaterial("Italiano");
        List<SupportMaterial> supportMaterials = new ArrayList<>();
        supportMaterials.add(studentModel);
        Mockito.when(professorService.getMaterial())
                .thenReturn(supportMaterials);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/professor/materials")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);

    }

    @Test
    public void addReporting() throws Exception{

        ReportingDTO reportingDTO = new ReportingDTO("nada", 1, 1, 7, 1);
        HttpServletRequest httpServletRequest = null;
        Map<String, Object> userData = JwtUtils.jwt2Map("fad32rfwej8i");
        Mockito.when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest))
                .thenReturn(userData);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/professor/addreporting", reportingDTO)
                .accept(MediaType.APPLICATION_JSON).content(String.valueOf(reportingDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);

    }

    @Test
    public void getClassroom() throws Exception{
        HttpServletRequest httpServletRequest = null;
        Map<String, Object> userData = JwtUtils.jwt2Map("fad32rfwej8i");
        Mockito.when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest))
                .thenReturn(userData);

        Classroom classroom = new Classroom("H1", new BigDecimal(1.0), new BigDecimal(1.0));
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroom);
        Mockito.when(professorService.getClassroom())
                .thenReturn(classrooms);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/professor/classrooms")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);

    }

    @Test
    public void getAllReporting() throws Exception{

        HttpServletRequest httpServletRequest = null;
        Map<String, Object> userData = JwtUtils.jwt2Map("fad32rfwej8i");
        Mockito.when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest))
                .thenReturn(userData);

        List<SupportMaterial> supportMaterials = new ArrayList<>();
        supportMaterials.add(new SupportMaterial());
        List<Secretary> secretaries = new ArrayList<>();
        secretaries.add(new Secretary());

        ReportingModel reportingModel = new ReportingModel(1, "ok", supportMaterials, "test", 1, new Professor(), secretaries, new Classroom());
        List<ReportingModel> reportingModelList = new ArrayList<>();
        reportingModelList.add(reportingModel);
        Mockito.when(professorService.getAllReporting())
                .thenReturn(reportingModelList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/professor/getAllReporting")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);

    }

    @Test
    public void getAllTeachingMaterials() throws Exception {
        HttpServletRequest httpServletRequest = null;
        Map<String, Object> userData = JwtUtils.jwt2Map("fad32rfwej8i");
        Mockito.when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest))
                .thenReturn(userData);

        TeachingMaterialModel teachingMaterial = new TeachingMaterialModel(1, new Subject("test", 1, 1), "files/4.jp");
        List<TeachingMaterialModel> teachingMaterialModels = new ArrayList<>();
        teachingMaterialModels.add(teachingMaterial);
        Mockito.when(professorService.getAllTeachingMaterialForStudent(9))
                .thenReturn(teachingMaterialModels);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("user/professor/getAllTeachingMaterials/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);

    }*/
}