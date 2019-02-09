package com.example.universitySE.models;

import com.example.universitySE.domain.Subject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TeachingMaterialModelTest {

    @Mock
    TeachingMaterialModel teachingMaterialModel;

    @Before
    public void setUp() throws Exception {
        teachingMaterialModel = new TeachingMaterialModel(1, new Subject("test",1,1),"test");
    }

    @Test
    public void setId() {
        teachingMaterialModel.setId(7);
        assertEquals(7, teachingMaterialModel.getId());
    }

    @Test
    public void setSubject() {
        teachingMaterialModel.setSubject(new Subject("test1",2,2));
        assertNotEquals(new Subject("test5",6,9), teachingMaterialModel.getSubject());
    }

    @Test
    public void setMedia() {
        teachingMaterialModel.setMedia("testnew");
        assertEquals("testnew", teachingMaterialModel.getMedia());
    }

    @Test
    public void getId() {
        assertEquals(1, teachingMaterialModel.getId());
    }

    @Test
    public void getSubject() {
        Subject subject = mock(Subject.class);
        assertNotEquals(teachingMaterialModel.getSubject(),subject);
    }

    @Test
    public void getMedia() {
        assertEquals("test", teachingMaterialModel.getMedia());
    }
}