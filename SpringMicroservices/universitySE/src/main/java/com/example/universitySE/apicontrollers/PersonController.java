package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.PersonLoginDTO;
import com.example.universitySE.exceptions.PersonNotLoggedInException;
import com.example.universitySE.exceptions.ProblemConnectionDbException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.shared.JSONResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class PersonController {

    @Autowired
    LoginServiceInterface loginService;

    @PostMapping("/login")
    public ResponseEntity<JSONResponseBody> loginUser(@Valid @RequestBody PersonLoginDTO personLoginDTO) {
        try {
            loginService.getPersonAndVerifyPassword(personLoginDTO.getUsername(), personLoginDTO.getPassword());
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), "ok"));
        } catch (PersonNotLoggedInException personNotLoggedInException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JSONResponseBody(HttpStatus.UNAUTHORIZED.value(), personNotLoggedInException.getMessage()));
        } catch (ProblemConnectionDbException problemConnectionDbException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), problemConnectionDbException.getMessage()));
        } catch (Exception exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), exception.getMessage()));
    }

    }
}
