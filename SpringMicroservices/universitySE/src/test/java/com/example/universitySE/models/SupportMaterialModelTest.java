package com.example.universitySE.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class SupportMaterialModelTest {

    @Mock
    SupportMaterialModel supportMaterialModel;

    @Before
    public void setUp() {
        supportMaterialModel = new SupportMaterialModel(1, "name");
    }

    @Test
    public void getId() {
        assertEquals(1, supportMaterialModel.getId());
    }

    @Test
    public void getName() {
        assertEquals("name", supportMaterialModel.getName());
    }

    @Test
    public void setId() {
        supportMaterialModel.setId(2);
        assertEquals(2, supportMaterialModel.getId());
    }

    @Test
    public void setName() {
        supportMaterialModel.setName("test");
        assertEquals("test", supportMaterialModel.getName());
    }
}