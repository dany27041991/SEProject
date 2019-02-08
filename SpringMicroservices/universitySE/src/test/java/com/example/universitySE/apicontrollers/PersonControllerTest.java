package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.PersonLoginDTO;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.models.MobilePersonModel;
import com.example.universitySE.models.StudentModel;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = PersonController.class, secure = false)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginServiceInterface loginServiceInterface;

    String exampleDTO = "{\"username\":\"hilary.pensive@student.com\",\"password\":\"student1\"}";

    StudentModel studentModel = new StudentModel(16, "hilary.pensive@student.com", 3 , "Hilary", "Pensive", new Date(1994,04,11), 10001, 1, new Date(1994,04,11));

    /*@Test
    public void loginUser() throws Exception{

        PersonLoginDTO personLoginDTO = new PersonLoginDTO("hislary.pensive@student.com", "student1");
        Mockito.when(loginServiceInterface.getPersonAndVerifyPassword(personLoginDTO.getUsername(), personLoginDTO.getPassword()))
                .thenReturn(studentModel);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/login", personLoginDTO)
                .accept(MediaType.APPLICATION_JSON).content(exampleDTO)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        String jwt = loginServiceInterface.createJwt("TeamGM", new Date(), "Unisalento","PersonalUnisalento");
        MockHttpServletResponse response = result.getResponse();
        response.setHeader("AUTHORIZATION", jwt);
        System.out.println(response);
    }

    @Test
    public void getAllUser() throws Exception{
        MobilePersonModel personModel = new MobilePersonModel(16, "hilary.pensive@student.com", "student1", 3, "Hilary", "Pensive", new Date(1994,04,11));
        List<MobilePersonModel> mobilePersonModels = new ArrayList<>();
        mobilePersonModels.add(personModel);
        Mockito.when(loginServiceInterface.getAllPersonMobile()).thenReturn(mobilePersonModels);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("user/getAll")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }*/
}