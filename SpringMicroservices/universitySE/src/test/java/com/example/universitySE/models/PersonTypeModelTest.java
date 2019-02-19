package com.example.universitySE.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class PersonTypeModelTest {

    @Mock
    PersonTypeModel personTypeModel;

    @Before
    public void setUp() {
        personTypeModel = new PersonTypeModel(1, "name");
    }

    @Test
    public void getId() {
        assertEquals(1, personTypeModel.getId());
    }

    @Test
    public void getName() {
        assertEquals("name", personTypeModel.getName());
    }

    @Test
    public void setId() {
        personTypeModel.setId(2);
        assertEquals(2, personTypeModel.getId());
    }

    @Test
    public void setName() {
        personTypeModel.setName("test");
        assertEquals("test", personTypeModel.getName());
    }
}