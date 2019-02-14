package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.*;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.SecretaryServiceInterface;
import com.example.universitySE.shared.JSONResponseBody;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("user/secretary")
public class SecretaryController {

    @Autowired
    SecretaryServiceInterface secretaryServiceInterface;

    @Autowired
    LoginServiceInterface loginServiceInterface;

    // -------------------------------------------- INSERT METHODS

    @PostMapping(value = "/insertperson")
    public ResponseEntity<JSONResponseBody> addPerson(HttpServletRequest request, @Valid @RequestBody PersonDTO personDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            long id = secretaryServiceInterface.savePersonRet(personDTO);

            if (personDTO.getPersonType() == 2) {

                ProfessorDTO professorDTO = new ProfessorDTO(id, personDTO.getUsername(), personDTO.getPassword(), personDTO.getPersonType(), personDTO.getFirstName(),
                        personDTO.getLastName(), personDTO.getBiography(), personDTO.getReceptionTime(), personDTO.getSubject(), personDTO.getDateOfBirth());
                secretaryServiceInterface.saveProfessor(professorDTO);
                return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), professorDTO));
            } else if (personDTO.getPersonType() == 3) {

                StudentDTO studentDTO = new StudentDTO(id, personDTO.getUsername(), personDTO.getPassword(), personDTO.getPersonType(), personDTO.getFirstName(),
                        personDTO.getLastName(), personDTO.getDateOfBirth(), personDTO.getBadgeNumber(), personDTO.getStudyCourse(), personDTO.getEnrollmentYear());
                secretaryServiceInterface.saveStudent(studentDTO);
                return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), studentDTO));
            }

            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), personDTO));
        }
        catch (PersonException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/insertsecretary")
    public ResponseEntity<JSONResponseBody> addSecretary(HttpServletRequest request, @Valid @RequestBody SecretaryDTO secretaryDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.saveSecretary(secretaryDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryDTO));
        }
        catch (SecretaryException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/insertstudycourse")
    public ResponseEntity<JSONResponseBody> addStudyCourse(HttpServletRequest request, @Valid @RequestBody StudyCourseDTO studyCourseDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.saveStudyCourse(studyCourseDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), studyCourseDTO));
        }
        catch (StudyCourseException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/insertsubject")
    public ResponseEntity<JSONResponseBody> addSubject(HttpServletRequest request, @Valid @RequestBody SubjectDTO subjectDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.saveSubject(subjectDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), subjectDTO));
        }
        catch (SubjectException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/insertclassroom")
    public ResponseEntity<JSONResponseBody> addClassroom(HttpServletRequest request, @Valid @RequestBody ClassroomDTO classroomDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.saveClassroom(classroomDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), classroomDTO));
        }
        catch (ClassroomException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/insertactivity")
    public ResponseEntity<JSONResponseBody> addActivity(HttpServletRequest request, @Valid @RequestBody ActivityDTO activityDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            long id = secretaryServiceInterface.saveActivityRet(activityDTO);

            if (activityDTO.getActivityType() == 1) {

                LessonDTO lessonDTO = new LessonDTO(activityDTO.getStudyCourse(), activityDTO.getSubject(), activityDTO.getIdProf(), activityDTO.getStart(),
                        activityDTO.getEnd(), activityDTO.getActivityType(), id);
                secretaryServiceInterface.saveLesson(lessonDTO);
                return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), lessonDTO));
            } else if (activityDTO.getActivityType() == 2) {

                ExamDTO examDTO = new ExamDTO(activityDTO.getStudyCourse(), activityDTO.getSubject(), activityDTO.getIdProf(), activityDTO.getStart(),
                        activityDTO.getEnd(), activityDTO.getActivityType(), id);
                secretaryServiceInterface.saveExam(examDTO);
                return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), examDTO));
            }

            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), activityDTO));
        }
        catch (ActivityException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/insertcarryoutactivity")
    public ResponseEntity<JSONResponseBody> addCarryoutActivity(HttpServletRequest request, @Valid @RequestBody CarryoutActivityDTO carryoutActivityDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.saveCarryoutActivity(carryoutActivityDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), carryoutActivityDTO));
        }
        catch (CarryoutActivityException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    // ----------------------------- UPDATE METHODS

    @PostMapping(value = "/updatereporting")
    public ResponseEntity<JSONResponseBody> updateReporting(HttpServletRequest request, @Valid @RequestBody ReportingRetDTO reportingRetDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.updateReporting(reportingRetDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), reportingRetDTO));
        }
        catch (ReportingException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @PostMapping(value = "/updatecarryoutactivity")
    public ResponseEntity<JSONResponseBody> updateCarryoutActivity(HttpServletRequest request, @Valid @RequestBody CarryoutActivityDTO carryoutActivityDTO) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            secretaryServiceInterface.updateCarryoutActivity(carryoutActivityDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), carryoutActivityDTO));
        }
        catch (CarryoutActivityException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    // ------------------------- RETURN MODEL METHODS

    @RequestMapping(value = "/faculty/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getFaculty(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getFaculty(id)));
        }
        catch (FacultyException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/persontype/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getPersonType(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getPersonType(id)));
        }
        catch (PersonTypeException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/activitytype/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getActivityType(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getActivityType(id)));
        }
        catch (ActivityTypeException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/state/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getState(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getState(id)));
        }
        catch (StateException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/supportmaterial/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getSupportMaterial(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getSupportMaterial(id)));
        }
        catch (SupportMaterialException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getProfessor(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getProfessor(id)));
        }
        catch (ProfessorException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/classroom/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getClassroom(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getClassroom(id)));
        }
        catch (ClassroomException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/secretary/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getSecretary(HttpServletRequest request, @PathVariable(name = "id") long id) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getSecretary(id)));
        }
        catch (SecretaryException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    // ------------------------- RETURN LIST METHODS

    @RequestMapping(value = "/courses/{faculty}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getStudyCourses(HttpServletRequest request, @PathVariable(name = "faculty") long faculty) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getStudyCourses(faculty)));
        }
        catch (StudyCourseException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/subjects/{studycourse}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getSubjects(HttpServletRequest request, @PathVariable(name = "studycourse") int studycourse) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getSubjects(studycourse)));
        }
        catch (SubjectException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/professors/{subject}", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getProfessors(HttpServletRequest request, @PathVariable(name = "subject") int subject) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getProfessors(subject)));
        }
        catch (ProfessorException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/classrooms", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getClassrooms(HttpServletRequest request) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getClassrooms()));
        }
        catch (ClassroomException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/persontypes", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getPersonTypes(HttpServletRequest request) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getPersonTypes()));
        }
        catch (PersonTypeException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/activitytypes", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getActivityTypes(HttpServletRequest request) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getActivityTypes()));
        }
        catch (ActivityTypeException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/states", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getStates(HttpServletRequest request) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getStates()));
        }
        catch (StateException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/supportmaterials", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getSupportMaterials(HttpServletRequest request) {
        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getSupportMaterials()));
        }
        catch (SupportMaterialException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/reportings", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getReportings(HttpServletRequest request) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getReportingsIterator()));
        }
        catch (ReportingException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/carryoutactivities", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getCarryoutActivities(HttpServletRequest request) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getCarryoutActivities()));
        }
        catch (CarryoutActivityException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/activitieswithoutclassroom", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getActivitiesWithoutClassroom(HttpServletRequest request) {

        try {

            loginServiceInterface.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getActivitiesWithoutClassroom()));
        }
        catch (ActivityException e1) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (UnsupportedEncodingException e2){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new JSONResponseBody(HttpStatus.EXPECTATION_FAILED.value(), e2.getMessage()));
        }
        catch (UserNotLoggedException e3){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONResponseBody(HttpStatus.FORBIDDEN.value(), e3.getMessage()));
        }
        catch (ExpiredJwtException e4){

            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JSONResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), e4.getMessage()));
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/carryoutactivitiescalendar", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getCarryoutActivitiesCalendar() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getCarryoutActivitiesCalendar()));
        }
        catch (CarryoutActivityException e1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/todaycarryoutactivitiescalendar", method = RequestMethod.GET)
    public ResponseEntity<JSONResponseBody> getTodayCarryoutActivitiesCalendar() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryServiceInterface.getTodayCarryoutActivitiesCalendar()));
        }
        catch (CarryoutActivityException e1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), e1.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

}
