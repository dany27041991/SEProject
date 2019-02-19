package com.example.universitySE.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class ActivityTypeModelTest {

    @Mock
    ActivityTypeModel activityTypeModel;

    @Before
    public void setUp() {
        activityTypeModel = new ActivityTypeModel(1, "name");
    }

    @Test
    public void getId() {
        assertEquals(1, activityTypeModel.getId());
    }

    @Test
    public void getName() {
        assertEquals("name", activityTypeModel.getName());
    }

    @Test
    public void setId() {
        activityTypeModel.setId(2);
        assertEquals(2, activityTypeModel.getId());
    }

    @Test
    public void setName() {
        activityTypeModel.setName("test");
        assertEquals("test", activityTypeModel.getName());
    }
}