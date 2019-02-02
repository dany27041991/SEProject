package com.example.universitySE.services;

import com.example.universitySE.domain.Person;
import com.example.universitySE.domain.Professor;
import com.example.universitySE.domain.Secretary;
import com.example.universitySE.domain.Student;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.models.*;
import com.example.universitySE.repositories.PersonRepository;
import com.example.universitySE.repositories.ProfessorRepository;
import com.example.universitySE.repositories.SecretaryRepository;
import com.example.universitySE.repositories.StudentRepository;
import com.example.universitySE.shared.TypePerson;
import com.example.universitySE.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

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
            if(person.get().getPersonType() == TypePerson.SECRETARY.ordinal()) {

                log.info("Secretary found!");
                //secretary
                Optional<Secretary> userSecretary = secretaryRepository.findSecretaryById(person.get().getId());
                Secretary secretaryLogged = userSecretary.get();
                SecretaryModel secretaryModel = new SecretaryModel(personLogged.getId(), personLogged.getUsername(),
                        personLogged.getPersonType(), secretaryLogged.getFaculty(), secretaryLogged.getVenue());
                return secretaryModel;
            }
            else if(person.get().getPersonType() == TypePerson.PROFESSOR.ordinal()) {

                log.info("Professor found!");
                //professor
                Optional<Professor> userProfessor = professorRepository.findProfessorById(person.get().getId());
                Professor professorLogged = userProfessor.get();
                ProfessorModel professorModel = new ProfessorModel(personLogged.getId(), personLogged.getUsername(),
                        personLogged.getPersonType(), professorLogged.getFirstName(), professorLogged.getLastName(),
                        professorLogged.getBiography(), professorLogged.getReceptionTime(), professorLogged.getSubject());
                return professorModel;
            }
            else if(person.get().getPersonType() == TypePerson.STUDENT.ordinal()) {

                log.info("Student found!");
                //student
                Optional<Student> userStudent = studentRepository.findStudentById(person.get().getId());
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

    @Override
    public List<MobilePersonModel> getAllPersonMobile() throws MobileUserException{
        List<MobilePersonModel> mobilePersonModels = new ArrayList<MobilePersonModel>();

        List<Person> personListTwo = personRepository.findAllByPersonType(TypePerson.SECRETARY.ordinal());
        for (int w = 0; w<personListTwo.size(); w++) {
            MobilePersonModel mobilePerson = new MobilePersonModel(personListTwo.get(w).getId(),
                    personListTwo.get(w).getUsername(), personListTwo.get(w).getPassword(),
                    personListTwo.get(w).getPersonType(), "Secretary"+(w+1),
                    "Secretary"+(w+1), null);
            mobilePersonModels.add(mobilePerson);
        }

        List<Person> personList = personRepository.findAllByPersonType(TypePerson.PROFESSOR.ordinal());
        for (int i = 0; i<personList.size(); i++) {
            Optional<Professor> professor = professorRepository.findProfessorById(personList.get(i).getId());
            if(professor.isPresent()) {
                Professor professorLogged = professor.get();
                MobilePersonModel mobilePerson = new MobilePersonModel(personList.get(i).getId(),
                        personList.get(i).getUsername(), personList.get(i).getPassword(),
                        personList.get(i).getPersonType(), professorLogged.getFirstName(),
                        professorLogged.getLastName(), professorLogged.getDateOfBirth());
                mobilePersonModels.add(mobilePerson);
            } else {
                throw new MobileUserException("A problem occurred. Chat not available. Try Later!");
            }
        }

        List<Person> personListOne = personRepository.findAllByPersonType(TypePerson.STUDENT.ordinal());
        for (int k = 0; k<personListOne.size(); k++) {
            Optional<Student> student = studentRepository.findStudentById(personListOne.get(k).getId());
            if(student.isPresent()) {
                Student studentLogged = student.get();
                MobilePersonModel mobilePerson = new MobilePersonModel(personListOne.get(k).getId(),
                        personListOne.get(k).getUsername(), personListOne.get(k).getPassword(),
                        personListOne.get(k).getPersonType(), studentLogged.getFirstName(),
                        studentLogged.getLastName(), studentLogged.getDateOfBirth());
                mobilePersonModels.add(mobilePerson);
            } else {
                throw new MobileUserException("A problem occurred. Chat not available. Try Later!");
            }
        }

        return mobilePersonModels;
    }
}