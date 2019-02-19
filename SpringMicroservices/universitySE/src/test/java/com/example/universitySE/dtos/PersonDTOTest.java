package com.example.universitySE.dtos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.junit.Assert.*;

public class PersonDTOTest {

    @Mock
    PersonDTO personDTO;

    @Before
    public void setUp() {
        personDTO = new PersonDTO("user", "pass", 1, "first", "last",
                "bio", "rec", 1, new Date(), 1, 1, new Date());
    }

    @Test
    public void getUsername() {
        assertEquals("user", personDTO.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("pass", personDTO.getPassword());
    }

    @Test
    public void getPersonType() {
        assertEquals(1, personDTO.getPersonType());
    }

    @Test
    public void getFirstName() {
        assertEquals("first", personDTO.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("last", personDTO.getLastName());
    }

    @Test
    public void getBiography() {
        assertEquals("bio", personDTO.getBiography());
    }

    @Test
    public void getReceptionTime() {
        assertEquals("rec", personDTO.getReceptionTime());
    }

    @Test
    public void getSubject() {
        assertEquals(1, personDTO.getSubject());
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(new Date(), personDTO.getDateOfBirth());
    }

    @Test
    public void getBadgeNumber() {
        assertEquals(1, personDTO.getBadgeNumber());
    }

    @Test
    public void getStudyCourse() {
        assertEquals(1, personDTO.getStudyCourse());
    }

    @Test
    public void getEnrollmentYear() {
        assertEquals(new Date(), personDTO.getEnrollmentYear());
    }

    @Test
    public void setUsername() {
        personDTO.setUsername("test");
        assertEquals("test", personDTO.getUsername());
    }

    @Test
    public void setPassword() {
        personDTO.setPassword("test");
        assertEquals("test", personDTO.getPassword());
    }

    @Test
    public void setPersonType() {
        personDTO.setPersonType(2);
        assertEquals(2, personDTO.getPersonType());
    }

    @Test
    public void setFirstName() {
        personDTO.setFirstName("test");
        assertEquals("test", personDTO.getFirstName());
    }

    @Test
    public void setLastName() {
        personDTO.setLastName("test");
        assertEquals("test", personDTO.getLastName());
    }

    @Test
    public void setBiography() {
        personDTO.setBiography("test");
        assertEquals("test", personDTO.getBiography());
    }

    @Test
    public void setReceptionTime() {
        personDTO.setReceptionTime("test");
        assertEquals("test", personDTO.getReceptionTime());
    }

    @Test
    public void setSubject() {
        personDTO.setSubject(2);
        assertEquals(2, personDTO.getSubject());
    }

    @Test
    public void setDateOfBirth() {
        personDTO.setDateOfBirth(new Date());
        assertEquals(new Date(), personDTO.getDateOfBirth());
    }

    @Test
    public void setBadgeNumber() {
        personDTO.setBadgeNumber(2);
        assertEquals(2, personDTO.getBadgeNumber());
    }

    @Test
    public void setStudyCourse() {
        personDTO.setStudyCourse(2);
        assertEquals(2, personDTO.getStudyCourse());
    }

    @Test
    public void setEnrollmentYear() {
        personDTO.setEnrollmentYear(new Date());
        assertEquals(new Date(), personDTO.getEnrollmentYear());
    }
}