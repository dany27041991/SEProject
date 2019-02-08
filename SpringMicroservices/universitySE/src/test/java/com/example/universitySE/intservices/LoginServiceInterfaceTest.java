package com.example.universitySE.intservices;

import com.example.universitySE.domain.Professor;
import com.example.universitySE.exceptions.MobileUserException;
import com.example.universitySE.exceptions.PersonNotLoggedInException;
import com.example.universitySE.exceptions.ProblemConnectionDbException;
import com.example.universitySE.exceptions.UserNotLoggedException;
import com.example.universitySE.models.MobilePersonModel;
import com.example.universitySE.repositories.PersonRepository;
import com.example.universitySE.services.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceInterfaceTest {

    @InjectMocks
    LoginService loginService;

    @Mock
    PersonRepository personRepository;

    //private static final String username = "test@test.com";
    //private static final String password = "test";

    @Test
    public void getPersonAndVerifyPassword() throws ProblemConnectionDbException, PersonNotLoggedInException {
        /*Professor professor = mock(Professor.class);
        when(professor.getId()).thenReturn(9);
        when(professor.getFirstName()).thenReturn("Arizona");
        when(professor.getLastName()).thenReturn("Robbins");
        when(professor.getBiography()).thenReturn("grey's anatomy");
        when(professor.getReceptionTime()).thenReturn("mon. 9 - 11");
        when(professor.getSubject()).thenReturn(6);
        when(professor.getDateOfBirth()).thenReturn(new Date(1994-03-29));
        when(loginService.getPersonAndVerifyPassword(username, password)).thenReturn(professor);*/
        personRepository.findPersonByUsernameAndPassword("arizona.robbins@prof.com", "professor6");
    }

    @Test
    public void createJwt() throws UnsupportedEncodingException {
        loginService.createJwt("test", new Date(), "test", "test");
    }

    @Test
    public void verifyJwtAndGetData() throws UnsupportedEncodingException, UserNotLoggedException, ExpiredJwtException {
        /*MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("AUTHORIZATION", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZWFtR00iLCJleHAiOjE1NDkyMTk0NTEsIm5hbWUiOiJVbmlzYWxlbnRvIiwic2NvcGUiOiJQZXJzb25hbFVuaXNhbGVudG8ifQ.juiVestWzBKT77YHGogsBD68d7BqRMah8GpisGdOCG0");
        doThrow(new ExpiredJwtException(mock(Header.class), mock(Claims.class), anyString())).when(loginService.verifyJwtAndGetData(request));*/
    }

    @Test
    public void getAllPersonMobile() throws MobileUserException {
        loginService.getAllPersonMobile();
        personRepository.findAllByPersonType(1);
    }
}