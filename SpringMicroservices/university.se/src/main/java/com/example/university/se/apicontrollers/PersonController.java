package com.example.university.se.apicontrollers;

import com.example.university.se.dtos.PersonLoginDTO;
import com.example.university.se.exceptions.PersonNotLoggedInException;
import com.example.university.se.intservices.LoginServiceInterface;
import com.example.university.se.shared.JSONResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class PersonController {

    @Autowired
    LoginServiceInterface loginService;

    @PostMapping("/login")
    public ResponseEntity<JSONResponseBody> loginUser(@Valid PersonLoginDTO personLoginDTO) {
        try {
            loginService.getPersonAndVerifyPassword(personLoginDTO.getUsername(), personLoginDTO.getPassword());
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), "OK"));
        } catch (PersonNotLoggedInException personNotLoggedIn) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), "User not exist. Try again to log in!"));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JSONResponseBody(HttpStatus.UNAUTHORIZED.value(), "Problem connection to database. Try later!"));
        }
    }
}
