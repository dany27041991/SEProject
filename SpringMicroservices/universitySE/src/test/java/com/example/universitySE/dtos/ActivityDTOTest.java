package com.example.universitySE.dtos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.junit.Assert.*;

public class ActivityDTOTest {

    @Mock
    ActivityDTO activityDTO;

    @Before
    public void setUp() {
        activityDTO = new ActivityDTO(1, 1, 1, new Date(), new Date(), 1);
    }

    @Test
    public void getStudyCourse() {
        assertEquals(1, activityDTO.getStudyCourse());
    }

    @Test
    public void getSubject() {
        assertEquals(1, activityDTO.getSubject());
    }

    @Test
    public void getIdProf() {
        assertEquals(1, activityDTO.getIdProf());
    }

    @Test
    public void getStart() {
        assertEquals(new Date(), activityDTO.getStart());
    }

    @Test
    public void getEnd() {
        assertNotEquals(new Date(12-12-1800), activityDTO.getEnd());
    }

    @Test
    public void getActivityType() {
        assertEquals(1, activityDTO.getActivityType());
    }

    @Test
    public void setStudyCourse() {
        activityDTO.setStudyCourse(2);
        assertEquals(2, activityDTO.getStudyCourse());
    }

    @Test
    public void setSubject() {
        activityDTO.setSubject(2);
        assertEquals(2, activityDTO.getSubject());
    }

    @Test
    public void setIdProf() {
        activityDTO.setIdProf(2);
        assertEquals(2, activityDTO.getIdProf());
    }

    @Test
    public void setStart() {
        activityDTO.setStart(new Date());
        assertEquals(new Date(), activityDTO.getStart());
    }

    @Test
    public void setEnd() {
        activityDTO.setEnd(new Date());
        assertEquals(new Date(), activityDTO.getEnd());
    }

    @Test
    public void setActivityType() {
        activityDTO.setActivityType(2);
        assertEquals(2, activityDTO.getActivityType());
    }
}