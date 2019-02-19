package com.example.universitySE.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class FacultyModelTest {

    @Mock
    FacultyModel facultyModel;

    @Before
    public void setUp() {
        facultyModel = new FacultyModel(1, "name");
    }

    @Test
    public void getId() {
        assertEquals(1, facultyModel.getId());
    }

    @Test
    public void getName() {
        assertEquals("name", facultyModel.getName());
    }

    @Test
    public void setId() {
        facultyModel.setId(2);
        assertEquals(2, facultyModel.getId());
    }

    @Test
    public void setName() {
        facultyModel.setName("test");
        assertEquals("test", facultyModel.getName());
    }
}