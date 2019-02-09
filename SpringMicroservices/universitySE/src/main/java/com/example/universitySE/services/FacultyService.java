package com.example.universitySE.services;

import com.example.universitySE.domain.Professor;
import com.example.universitySE.domain.Student;
import com.example.universitySE.domain.Subject;
import com.example.universitySE.intservices.FacultyServiceInterface;
import com.example.universitySE.repositories.PersonRepository;
import com.example.universitySE.repositories.ProfessorRepository;
import com.example.universitySE.repositories.StudentRepository;
import com.example.universitySE.repositories.SubjectRepository;
import com.example.universitySE.shared.TypePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService implements FacultyServiceInterface{

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Subject> getAllSubject() {
        List<Subject> subjectList = subjectRepository.findAll();
        return subjectList;
    }

    @Override
    public List<Integer> getLoggedUserSubject(Integer id, Integer type) throws Exception {
        List<Integer> idSubjects = new ArrayList<Integer>();
        if(type == TypePerson.PROFESSOR.ordinal()) {
            Optional<Professor> prof = professorRepository.findProfessorById(id);
            if(prof.isPresent()) {
                Professor professor = prof.get();
                idSubjects.add(professor.getSubject());
            } else {
                throw new Exception();
            }
        } else if(type == TypePerson.STUDENT.ordinal()){
            Optional<Student> stud = studentRepository.findStudentById(id);
            if(stud.isPresent()) {
                Student student = stud.get();
                List<Subject> subjects = subjectRepository.findSubjectByStudyCourse(student.getStudyCourse());
                for (int i=0; i<subjects.size(); i++){
                    idSubjects.add((int) subjects.get(i).getId());
                }
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
        return idSubjects;
    }
}
