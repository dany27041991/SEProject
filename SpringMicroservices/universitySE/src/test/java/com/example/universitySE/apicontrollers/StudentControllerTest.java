package com.example.universitySE.apicontrollers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

    /*@Test
    public void getAllReporting() {

    }

    @Test
    public void getLastUploadMaterial() {
    }*/
}