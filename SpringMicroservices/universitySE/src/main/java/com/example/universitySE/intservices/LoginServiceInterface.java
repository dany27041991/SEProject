package com.example.universitySE.intservices;

import com.example.universitySE.exceptions.*;
import com.example.universitySE.models.MobilePersonModel;
import io.jsonwebtoken.ExpiredJwtException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LoginServiceInterface {

    Object getPersonAndVerifyPassword(String username, String password) throws PersonNotLoggedInException, ProblemConnectionDbException;

    String createJwt(String subject, Date date, String name, String scope) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException, ExpiredJwtException;

    List<MobilePersonModel> getAllPersonMobile() throws MobileUserException;
}

