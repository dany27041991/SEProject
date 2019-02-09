package com.example.universitySE.dtos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class RatingDTOTest {

    @Mock
    RatingDTO ratingDTO;

    @Before
    public void setUp() {
        ratingDTO = new RatingDTO(1,1,1,"test");
    }

    @Test
    public void setId_student() {
        ratingDTO.setId_student(5);
        assertEquals(5, ratingDTO.getId_student());
    }

    @Test
    public void setFeedback_student() {
        ratingDTO.setFeedback_student(5);
        assertEquals(5, ratingDTO.getFeedback_student());
    }

    @Test
    public void setId_teaching_material() {
        ratingDTO.setId_teaching_material(5);
        assertEquals(5, ratingDTO.getId_teaching_material());
    }

    @Test
    public void setNote() {
        ratingDTO.setNote("test");
        assertEquals("test", ratingDTO.getNote());
    }

    @Test
    public void getId_student() {
        assertEquals(1, ratingDTO.getId_student());
    }

    @Test
    public void getFeedback_student() {
        assertEquals(1, ratingDTO.getFeedback_student());
    }

    @Test
    public void getId_teaching_material() {
        assertEquals(1, ratingDTO.getId_teaching_material());
    }

    @Test
    public void getNote() {
        assertEquals("test", ratingDTO.getNote());
    }
}