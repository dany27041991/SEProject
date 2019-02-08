package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.PersonLoginDTO;
import com.example.universitySE.exceptions.MobileUserException;
import com.example.universitySE.exceptions.PersonNotLoggedInException;
import com.example.universitySE.exceptions.ProblemConnectionDbException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.shared.JSONResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("user")
public class PersonController {

    @Autowired
    LoginServiceInterface loginService;

    @PostMapping(value = "/login", headers = "Content-Type=application/json")
    public ResponseEntity<JSONResponseBody> loginUser(@Valid @RequestBody PersonLoginDTO personLoginDTO) {
        try {
            String jwt = loginService.createJwt("TeamGM", new Date(), "Unisalento","PersonalUnisalento");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.AUTHORIZATION,jwt);
            Object person = loginService.getPersonAndVerifyPassword(personLoginDTO.getUsername(), personLoginDTO.getPassword());
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(new JSONResponseBody(HttpStatus.OK.value(), person));
        } catch (PersonNotLoggedInException personNotLoggedInException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JSONResponseBody(HttpStatus.UNAUTHORIZED.value(), personNotLoggedInException.getMessage()));
        } catch (ProblemConnectionDbException problemConnectionDbException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), problemConnectionDbException.getMessage()));
        } catch (Exception exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), exception.getMessage()));
        }

    }

    @PostMapping(value = "/getAll")
    public ResponseEntity<JSONResponseBody> getAllUser() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), loginService.getAllPersonMobile()));
        } catch (MobileUserException e1) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new JSONResponseBody(HttpStatus.SERVICE_UNAVAILABLE.value(), e1.getMessage()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), exception.getMessage()));
        }

    }
}
