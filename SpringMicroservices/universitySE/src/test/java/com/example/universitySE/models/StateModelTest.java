package com.example.universitySE.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class StateModelTest {

    @Mock
    StateModel stateModel;

    @Before
    public void setUp() {
        stateModel = new StateModel(1, "name");
    }

    @Test
    public void getId() {
        assertEquals(1, stateModel.getId());
    }

    @Test
    public void getName() {
        assertEquals("name", stateModel.getName());
    }

    @Test
    public void setId() {
        stateModel.setId(2);
        assertEquals(2, stateModel.getId());
    }

    @Test
    public void setName() {
        stateModel.setName("test");
        assertEquals("test", stateModel.getName());
    }
}