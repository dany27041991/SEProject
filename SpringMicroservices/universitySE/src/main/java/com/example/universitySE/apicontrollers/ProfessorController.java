package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.ReportingDTO;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.services.LoginService;
import com.example.universitySE.services.ProfessorService;
import com.example.universitySE.shared.JSONResponseBody;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.ui.Model;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("user/professor")
public class ProfessorController {

    @Autowired
    LoginService loginService;

    @Autowired
    ProfessorService professorService;

    List<String> files = new ArrayList<String>();

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getSubject(HttpServletRequest request, @PathVariable(name = "id") int id) {
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
    public ResponseEntity<JSONResponseBody> getMaterials(HttpServletRequest request) {
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

    @RequestMapping(value = "/addreporting", method = RequestMethod.POST)
    public ResponseEntity<JSONResponseBody> addReporting(HttpServletRequest request, @Valid @RequestBody ReportingDTO reportingDTO) {
        try {
            loginService.verifyJwtAndGetData(request);
            professorService.addReporting(reportingDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), true));
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

    @RequestMapping(value = "/classrooms", method = RequestMethod.POST)
    public ResponseEntity<JSONResponseBody> getClassroom(HttpServletRequest request) {
        try {
            loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), professorService.getClassroom()));
        } catch (ClassroomException e1) {
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

    @PostMapping("/getAllReporting")
    public ResponseEntity<JSONResponseBody> getAllReporting(HttpServletRequest request) {
        try {
            loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), professorService.getAllReporting()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<JSONResponseBody> handleFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("id_prof") String id_prof, @RequestParam("subject") int subject) {
        try {
            loginService.verifyJwtAndGetData(request);
            professorService.store(file, id_prof, subject);
            files.add(file.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), true));
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

    @PostMapping("/getAllTeachingMaterials")
    public ResponseEntity<JSONResponseBody> getAllTeachingMaterials(@RequestParam(value = "id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), professorService.getAllTeachingMaterialForStudent(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

}
