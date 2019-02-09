package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.RatingDTO;
import com.example.universitySE.dtos.SubjectDTO;
import com.example.universitySE.intservices.StudentServiceInterface;
import com.example.universitySE.models.LastUploadModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentServiceInterface serviceInterface;

    @Test
    public void addRating() throws Exception {
        RatingDTO ratingDTO = mock(RatingDTO.class);
        serviceInterface.addRating(ratingDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/student/addrating", ratingDTO)
                .accept(MediaType.APPLICATION_JSON).content(String.valueOf(ratingDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void getLastUploadMaterial() throws Exception {
        SubjectDTO subjectDTO = mock(SubjectDTO.class);
        LastUploadModel lastUploadModel = mock(LastUploadModel.class);
        List<LastUploadModel> lastUploadModels = new ArrayList<>();
        lastUploadModels.add(lastUploadModel);
        when(serviceInterface.getLastUpload(subjectDTO.getSubjects())).thenReturn(lastUploadModels);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("user/student/addrating", subjectDTO)
                .accept(MediaType.APPLICATION_JSON).content(String.valueOf(subjectDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }
}