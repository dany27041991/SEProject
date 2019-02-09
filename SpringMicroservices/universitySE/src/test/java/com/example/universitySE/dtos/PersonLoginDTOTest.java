package com.example.universitySE.dtos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class PersonLoginDTOTest {

    @Mock
    PersonLoginDTO personLoginDTO;

    @Before
    public void setUp() {
        personLoginDTO = new PersonLoginDTO("test","test");
    }

    @Test
    public void setUsername() {
        personLoginDTO.setUsername("test1");
        assertNotEquals("text", personLoginDTO.getUsername());
    }

    @Test
    public void setPassword() {
        personLoginDTO.setPassword("test1");
        assertNotEquals("text", personLoginDTO.getPassword());
    }

    @Test
    public void getUsername() {
        assertEquals("test",personLoginDTO.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("test",personLoginDTO.getPassword());
    }
}