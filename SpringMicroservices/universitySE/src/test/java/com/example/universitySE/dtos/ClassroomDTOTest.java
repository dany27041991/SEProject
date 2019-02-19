package com.example.universitySE.dtos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ClassroomDTOTest {

    @Mock
    ClassroomDTO classroomDTO;

    @Before
    public void setUp() {
        classroomDTO = new ClassroomDTO("name test", new BigDecimal(1), new BigDecimal(2));
    }

    @Test
    public void getName() {
        assertEquals("name test", classroomDTO.getName());
    }

    @Test
    public void getLatitude() {
        assertEquals(new BigDecimal(1), classroomDTO.getLatitude());
    }

    @Test
    public void getLongitude() {
        assertEquals(new BigDecimal(2), classroomDTO.getLongitude());
    }

    @Test
    public void setName() {
        classroomDTO.setName("name");
        assertEquals("name", classroomDTO.getName());
    }

    @Test
    public void setLatitude() {
        classroomDTO.setLatitude(new BigDecimal(3));
        assertEquals(new BigDecimal(3), classroomDTO.getLatitude());
    }

    @Test
    public void setLongitude() {
        classroomDTO.setLongitude(new BigDecimal(4));
        assertEquals(new BigDecimal(4), classroomDTO.getLongitude());

    }
}