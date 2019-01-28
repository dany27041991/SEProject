package com.example.universitySE.apicontrollers;

import com.example.universitySE.exceptions.MaterialException;
import com.example.universitySE.exceptions.SubjectException;
import com.example.universitySE.exceptions.UserNotLoggedException;
import com.example.universitySE.services.LoginService;
import com.example.universitySE.services.ProfessorService;
import com.example.universitySE.shared.JSONResponseBody;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("user/professor")
public class ProfessorController {

    @Autowired
    LoginService loginService;

    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getContacts(HttpServletRequest request, @PathVariable(name = "id") int id) {
        try {
            loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), professorService.getSubject(id)));
        } catch (SubjectException e1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        } catch (UnsupportedEncodingException e2){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }catch (UserNotLoggedException e3){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }catch (ExpiredJwtException e4){
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/materials", method = RequestMethod.POST)
    public ResponseEntity<JSONResponseBody> getContacts(HttpServletRequest request) {
        try {
            loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), professorService.getMaterial()));
        } catch (MaterialException e1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        } catch (UnsupportedEncodingException e2){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }catch (UserNotLoggedException e3){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }catch (ExpiredJwtException e4){
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }
}
