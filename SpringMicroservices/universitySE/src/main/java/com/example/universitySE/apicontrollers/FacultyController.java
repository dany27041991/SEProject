package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.IdTypeForSubjectDTO;
import com.example.universitySE.intservices.FacultyServiceInterface;
import com.example.universitySE.shared.JSONResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user/faculty")
public class FacultyController {

    @Autowired
    FacultyServiceInterface facultyService;

    @PostMapping(value = "/getAllSubject")
    public ResponseEntity<JSONResponseBody> getAllUser() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), facultyService.getAllSubject()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), exception.getMessage()));
        }

    }

    @PostMapping(value = "/getSubjectUserLogged")
    public ResponseEntity<JSONResponseBody> loginUser(@Valid @RequestBody IdTypeForSubjectDTO idTypeForSubjectDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), facultyService.getLoggedUserSubject(idTypeForSubjectDTO.getId(), idTypeForSubjectDTO.getType())));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), exception.getMessage()));
        }
    }
}
