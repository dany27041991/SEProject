package com.example.universitySE.models;

import com.example.universitySE.domain.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class LastUploadModelTest {

    @Mock
    LastUploadModel lastUploadModel;

    @Before
    public void setUp() throws Exception {
        lastUploadModel = new LastUploadModel();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Exit from LastUploadModelTest!");
    }

    @Test
    public void setId() {
        lastUploadModel.setId(1);
        assertEquals(1, lastUploadModel.getId());
    }

    @Test
    public void setSubject() {
        lastUploadModel.setSubject(new Subject("test",1, 1));
        assertNotNull(lastUploadModel.getSubject());
    }

    @Test
    public void setMedia() {
        lastUploadModel.setMedia("test");
        assertNotEquals("hello", lastUploadModel.getMedia());
    }

    @Test
    public void getId() {
        lastUploadModel.setId(566);
        assertEquals(566, lastUploadModel.getId());
    }

    @Test
    public void getSubject() {
        assertNull(lastUploadModel.getSubject());
    }

    @Test
    public void getMedia() {
        assertTrue(lastUploadModel.getMedia()==null);
    }
}