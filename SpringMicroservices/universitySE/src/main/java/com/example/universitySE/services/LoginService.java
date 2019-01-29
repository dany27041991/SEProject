package com.example.universitySE.services;

import com.example.universitySE.domain.*;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.models.ProfessorModel;
import com.example.universitySE.models.SecretaryModel;
import com.example.universitySE.models.StudentModel;
import com.example.universitySE.repositories.PersonRepository;
import com.example.universitySE.repositories.ProfessorRepository;
import com.example.universitySE.repositories.SecretaryRepository;
import com.example.universitySE.repositories.StudentRepository;
import com.example.universitySE.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService implements LoginServiceInterface{

    private static final Logger log = LoggerFactory.getLogger(LoginServiceInterface.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SecretaryRepository secretaryRepository;

    @Override
    public Object getPersonAndVerifyPassword(String username, String password) throws PersonNotLoggedInException, ProblemConnectionDbException {
        Optional<Person> person = personRepository.findPersonByUsernameAndPassword(username, password);
        if(person.isPresent()) {
            log.info("Person exists!");
            Person personLogged = person.get();
            if(personLogged.getPersonType() == 1) {

                log.info("Secretary found!");
                //secretary
                Optional<Secretary> userSecretary = secretaryRepository.findSecretaryById(personLogged.getId());
                Secretary secretaryLogged = userSecretary.get();
                SecretaryModel secretaryModel = new SecretaryModel(personLogged.getId(), personLogged.getUsername(),
                        personLogged.getPersonType(), secretaryLogged.getFaculty(), secretaryLogged.getVenue());
                return secretaryModel;
            }
            else if(personLogged.getPersonType() == 2) {

                log.info("Professor found!");
                //professor
                Optional<Professor> userProfessor = professorRepository.findProfessorById(personLogged.getId());
                Professor professorLogged = userProfessor.get();
                ProfessorModel professorModel = new ProfessorModel(personLogged.getId(), personLogged.getUsername(),
                        personLogged.getPersonType(), professorLogged.getFirstName(), professorLogged.getLastName(),
                        professorLogged.getBiography(), professorLogged.getReceptionTime(), professorLogged.getSubject());
                return professorModel;
            }
            else if(personLogged.getPersonType() == 3) {

                log.info("Student found!");
                //student
                Optional<Student> userStudent = studentRepository.findStudentById(personLogged.getId());
                Student studentLogged = userStudent.get();
                StudentModel studentModel = new StudentModel(personLogged.getId(), personLogged.getUsername(),
                        personLogged.getPersonType(), studentLogged.getFirstName(), studentLogged.getLastName(),
                        studentLogged.getDateOfBirth(), studentLogged.getBadgeNumber(), studentLogged.getStudyCourse(),
                        studentLogged.getEnrollmentYear());
                return studentModel;
            }
            else {

                throw new ProblemConnectionDbException("Connection problem to database!");
            }
        }
        else {
            log.info("Person not exist or wrong password!");
            throw new PersonNotLoggedInException("Person not correctly logged in! Try again!");
        }
    }

    @Override
    public String createJwt(String subject, Date date, String name, String scope ) throws UnsupportedEncodingException {
        String token = JwtUtils.generateJwt(subject, new Date(), name, scope);
        return token;
    }

    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException, ExpiredJwtException {
        //controllo il Jwt della request del client
        String jwt = JwtUtils.getJwtFromHttpRequest(request);
        if(jwt == null){
            throw new UserNotLoggedException("Authentication token not found in the request");
        }
        Map<String, Object> userData = JwtUtils.jwt2Map(jwt);
        return userData;
    }
}