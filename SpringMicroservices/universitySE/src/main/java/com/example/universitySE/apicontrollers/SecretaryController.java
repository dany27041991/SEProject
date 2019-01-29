package com.example.universitySE.apicontrollers;

import com.example.universitySE.dtos.*;
import com.example.universitySE.intservices.SecretaryServiceInterface;
import com.example.universitySE.shared.JSONResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("secretary")
public class SecretaryController {

    private static final Logger log = LoggerFactory.getLogger(SecretaryServiceInterface.class);
    HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    SecretaryServiceInterface secretaryServiceInterface;

    // da dividere in tre metodi diversi
    @PostMapping(value = "/adduser")
    public ResponseEntity<JSONResponseBody> addUser(@RequestParam(value = "id") int id,
                                                    @RequestParam(value = "username") String username,
                                                    @RequestParam(value = "password") String password,
                                                    @RequestParam(value = "personType") int personType,
                                                    @RequestParam(value = "faculty") int faculty,
                                                    @RequestParam(value = "venue") String venue,
                                                    @RequestParam(value = "firstName") String firstName,
                                                    @RequestParam(value = "lastName") String lastName,
                                                    @RequestParam(value = "biography") String biography,
                                                    @RequestParam(value = "receptionTime") String receptionTime,
                                                    @RequestParam(value = "subject") int subject,
                                                    @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                                    @RequestParam(value = "badgeNumber") int badgeNumber,
                                                    @RequestParam(value = "studyCourse") int studyCourse,
                                                    @RequestParam(value = "enrollmentYear") String enrollmentYear) throws ParseException {

        PersonDTO personDTO = new PersonDTO(id, username, password, personType);

        if (personType == 1) {

            secretaryServiceInterface.savePerson(personDTO);

            SecretaryDTO secretaryDTO = new SecretaryDTO(id, faculty, venue);
            secretaryServiceInterface.saveSecretary(secretaryDTO);

            log.info("added new secretary");
            return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), secretaryDTO));
        }
        else if (personType == 2) {

            secretaryServiceInterface.savePerson(personDTO);

            ProfessorDTO professorDTO = new ProfessorDTO(id, firstName, lastName, biography, receptionTime, subject);
            secretaryServiceInterface.saveProfessor(professorDTO);

            log.info("added new professor");
            return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), professorDTO));
        }
        else if (personType == 3) {

            Date convDateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
            Date convEnrollmentYear = new SimpleDateFormat("yyyy-MM-dd").parse(enrollmentYear);

            secretaryServiceInterface.savePerson(personDTO);

            StudentDTO studentDTO = new StudentDTO(id, firstName, lastName, convDateOfBirth, badgeNumber, studyCourse, convEnrollmentYear);
            secretaryServiceInterface.saveStudent(studentDTO);

            log.info("added new student");
            return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), studentDTO));
        }
        else {

            log.info("not a valid person type");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), "not found"));
        }
    }

    @PostMapping(value = "/addstudycourse")
    public ResponseEntity<JSONResponseBody> addStudyCourse(@RequestParam(value = "id") int id,
                                                           @RequestParam(value = "name") String name,
                                                           @RequestParam(value = "faculty") int faculty) {

        StudyCourseDTO studyCourseDTO = new StudyCourseDTO(id, name, faculty);
        secretaryServiceInterface.saveStudyCourse(studyCourseDTO);

        log.info("added new course of study");
        return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), studyCourseDTO));
    }

    @PostMapping(value = "/addsubject")
    public ResponseEntity<JSONResponseBody> addSubject(@RequestParam(value = "id") int id,
                                                       @RequestParam(value = "name") String name,
                                                       @RequestParam(value = "studyCourse") int studyCourse,
                                                       @RequestParam(value = "yearCourse") int yearCourse) {

        SubjectDTO subjectDTO = new SubjectDTO(id, name, studyCourse, yearCourse);
        secretaryServiceInterface.saveSubject(subjectDTO);

        log.info("added new subject");
        return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), subjectDTO));
    }

    @PostMapping(value = "/addclassroom")
    public ResponseEntity<JSONResponseBody> addClassroom(@RequestParam(value = "id") int id,
                                                         @RequestParam(value = "name") String name,
                                                         @RequestParam(value = "latitude") BigDecimal latitude,
                                                         @RequestParam(value = "longitude") BigDecimal longitude) {

        ClassroomDTO classroomDTO = new ClassroomDTO(id, name, latitude, longitude);
        secretaryServiceInterface.saveClassroom(classroomDTO);

        log.info("added new classroom");
        return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), classroomDTO));
    }

    // da dividere in due metodi diversi
    @PostMapping(value = "/addactivity")
    public ResponseEntity<JSONResponseBody> addActivity(@RequestParam(value = "id") int id,
                                                        @RequestParam(value = "studyCourse") int studyCourse,
                                                        @RequestParam(value = "subject") int subject,
                                                        @RequestParam(value = "idProf") int idProf,
                                                        @RequestParam(value = "start") String start,
                                                        @RequestParam(value = "end") String end,
                                                        @RequestParam(value = "classroomName") int classroomName,
                                                        @RequestParam(value = "activityType") int activityType) throws ParseException {

        Date convStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(start);
        Date convEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(end);

        ActivityDTO activityDTO = new ActivityDTO(id, studyCourse, subject, idProf, convStart, convEnd, classroomName, activityType);

        if (activityType == 1) {

            secretaryServiceInterface.saveActivity(activityDTO);

            LessonDTO lessonDTO = new LessonDTO(id);
            secretaryServiceInterface.saveLesson(lessonDTO);

            log.info("added new lesson");
            return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), lessonDTO));
        }
        else if (activityType == 2) {

            secretaryServiceInterface.saveActivity(activityDTO);

            ExamDTO examDTO = new ExamDTO(id);
            secretaryServiceInterface.saveExam(examDTO);

            log.info("added new exam");
            return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.OK.value(), examDTO));
        }
        else {

            log.info("not a valid activity type");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header(String.valueOf(httpHeaders)).body(new JSONResponseBody(HttpStatus.NOT_FOUND.value(), "not found"));
        }
    }

}
