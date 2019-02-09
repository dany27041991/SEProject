package com.example.universitySE.intservices;

import com.example.universitySE.exceptions.MobileUserException;
import com.example.universitySE.exceptions.PersonNotLoggedInException;
import com.example.universitySE.exceptions.ProblemConnectionDbException;
import com.example.universitySE.exceptions.UserNotLoggedException;
import com.example.universitySE.models.MobilePersonModel;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceInterfaceTest {

    @Mock
    LoginServiceInterface loginServiceInterface = mock(LoginServiceInterface.class);

    private static final String username = "test@test.com";
    private static final String password = "test";

    @Test
    public void getPersonAndVerifyPassword() throws ProblemConnectionDbException, PersonNotLoggedInException {
        Object obj = mock(Object.class);
        when(loginServiceInterface.getPersonAndVerifyPassword(username, password)).thenReturn(obj);

        Object object = loginServiceInterface.getPersonAndVerifyPassword("test", "test");
        assertNotEquals(object, obj);
    }

    @Test
    public void createJwt() throws UnsupportedEncodingException {
        Date date = mock(Date.class);
        loginServiceInterface.createJwt("test", date, "test1", "test2");
    }

    @Test
    public void verifyJwtAndGetData() throws UnsupportedEncodingException, UserNotLoggedException, ExpiredJwtException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getAllPersonMobile() throws MobileUserException {
        MobilePersonModel mobilePersonModel = mock(MobilePersonModel.class);
        List<MobilePersonModel> mobilePersonModelList = new ArrayList<>();
        mobilePersonModelList.add(mobilePersonModel);
        when(loginServiceInterface.getAllPersonMobile()).thenReturn(mobilePersonModelList);

        MobilePersonModel mobilePersonModel1 = mock(MobilePersonModel.class);
        assertNotEquals(mobilePersonModel, mobilePersonModel1);
    }
}