package com.example.universitySE.intservices;

import com.example.universitySE.domain.Professor;
import com.example.universitySE.domain.Subject;
import com.example.universitySE.repositories.PersonRepository;
import com.example.universitySE.repositories.ProfessorRepository;
import com.example.universitySE.repositories.StudentRepository;
import com.example.universitySE.repositories.SubjectRepository;
import com.example.universitySE.services.FacultyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class FacultyServiceInterfaceTest {

    @InjectMocks
    FacultyService facultyService;

    @Mock
    SubjectRepository subjectRepository;

    @Mock
    PersonRepository personRepository;

    @Mock
    ProfessorRepository professorRepository;

    @Mock
    StudentRepository studentRepository;

    @Test
    public void getAllSubject() {
        facultyService.getAllSubject();
        verify(subjectRepository).findAll();
    }

    @Test
    public void getLoggedUserSubject() throws Exception {
        /*List<Integer> number = mock(List.class);
        number.add(7);
        when(facultyService.getLoggedUserSubject(10, 2)).thenReturn(number);*/
        professorRepository.findProfessorById(10);
        studentRepository.findStudentById(16);
    }
}