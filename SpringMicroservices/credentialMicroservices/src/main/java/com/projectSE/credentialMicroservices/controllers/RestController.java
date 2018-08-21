package com.projectSE.credentialMicroservices.controllers;

import com.projectSE.credentialMicroservices.entities.JsonResponseBody;
import com.projectSE.credentialMicroservices.entities.User;
import com.projectSE.credentialMicroservices.exceptions.UserNotLoggedException;
import com.projectSE.credentialMicroservices.services.LoginService;
import com.projectSE.credentialMicroservices.services.RegistrationService;
import com.projectSE.credentialMicroservices.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;

@Controller
public class RestController {

    @Autowired
    LoginService loginService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    EncryptionUtils encryptionUtils;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBody> registrationUser(@RequestParam(name = "name") String name,
         @RequestParam(name = "surname") String surname, @RequestParam(name = "password") String password,
         @RequestParam(name = "type") int type, @RequestParam(name = "id_course_of_study") int id_course_of_study) {
        try {
            if(registrationService.controlPatternPassword(password))
            {
                String emailGenerated = registrationService.createEmail(name, surname);
                registrationService.saveUser(name, surname, emailGenerated, encryptionUtils.encrypt(password), type, id_course_of_study);
                return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Registration was successful. Remember your institutional email: " +emailGenerated));
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Registration Failed! The password must: 1) Be between 6 and 20 characters," +
                        "2) Contain at least one digit, 3) Contain at least a lower case letter, 4) Contain at least an upper case letter, " +
                        "5) Contain at least a special character among the following [@ # $ % ^ & + =], 6) Contain no whitespace in the string."));
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Registration Failed! Problem Connection! "+exception.toString()));
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBody> logiUser(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        try {
            Optional<User> userr = loginService.getUserFromDbAndVerifyPassword(email, password);
            if(userr.isPresent()) {
                User user = userr.get();
                String jwt = loginService.createJwt(String.valueOf(user.getId_user()), user.getName(), user.getEmail(), new Date());
                return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body(new JsonResponseBody(HttpStatus.OK.value(), user));
            }
        } catch (UserNotLoggedException exception1) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Login Failed! Wrong Credentials! "+exception1));
        } catch (UnsupportedEncodingException exception2) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Token Error! " +exception2));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "No correspondence in the database of users!"));
    }

}
