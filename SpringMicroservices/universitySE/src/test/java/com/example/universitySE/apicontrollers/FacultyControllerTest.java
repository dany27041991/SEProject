package com.example.universitySE.apicontrollers;

import com.example.universitySE.domain.Subject;
import com.example.universitySE.dtos.IdTypeForSubjectDTO;
import com.example.universitySE.intservices.FacultyServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = FacultyController.class, secure = false)
public class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FacultyServiceInterface facultyService;

    String exampleDTO = "{\"id\":\"1\",\"type\":\"1\"}";

    @Test
    public void getAllSubject() throws Exception {
        Subject subject = new Subject("test",1,1);
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject);

        Mockito.when(facultyService.getAllSubject())
                .thenReturn(subjectList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/faculty/getAllSubject")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void loginUser() throws Exception {

        IdTypeForSubjectDTO idTypeForSubjectDTO = new IdTypeForSubjectDTO(1,1);
        List<Integer> number = new ArrayList<>();
        number.add(1);
        Mockito.when(facultyService.getLoggedUserSubject(idTypeForSubjectDTO.getId(), idTypeForSubjectDTO.getType()))
                .thenReturn(number);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/faculty/getSubjectUserLogged", idTypeForSubjectDTO)
                .accept(MediaType.APPLICATION_JSON).content(exampleDTO)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }
}