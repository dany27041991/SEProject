package com.example.universitySE.intservices;

import com.example.universitySE.domain.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class FacultyServiceInterfaceTest {

    @Mock
    FacultyServiceInterface facultyServiceInterface;

    @Test
    public void getAllSubject() {
        Subject subject = mock(Subject.class);
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject);
        when(facultyServiceInterface.getAllSubject()).thenReturn(subjectList);

        List<Subject> subjects = facultyServiceInterface.getAllSubject();
        assertEquals(subjects, subjectList);
    }

    @Test
    public void getLoggedUserSubject() throws Exception {
        List<Integer> number = mock(List.class);
        when(facultyServiceInterface.getLoggedUserSubject(10, 2)).thenReturn(number);

        List<Integer> integers = facultyServiceInterface.getLoggedUserSubject(9, 3);
        assertNotEquals(number, integers);
    }
}