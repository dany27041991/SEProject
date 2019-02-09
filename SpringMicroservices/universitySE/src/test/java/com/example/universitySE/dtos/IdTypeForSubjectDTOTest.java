package com.example.universitySE.dtos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IdTypeForSubjectDTOTest {

    @Mock
    IdTypeForSubjectDTO subjectDTOTest;

    @Before
    public void setUp() {
        subjectDTOTest = new IdTypeForSubjectDTO(1,1);
    }

    @Test
    public void setId() {
        subjectDTOTest.setId(2);
        assertEquals(2, subjectDTOTest.getId());
    }

    @Test
    public void setType() {
        subjectDTOTest.setType(2);
        assertEquals(2, subjectDTOTest.getType());
    }

    @Test
    public void getId() {
        assertEquals(1,subjectDTOTest.getId());
    }

    @Test
    public void getType() {
        assertEquals(1,subjectDTOTest.getType());
    }
}