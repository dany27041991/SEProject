package com.example.universitySE.services;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.*;
import com.example.universitySE.intservices.SecretaryServiceInterface;
import com.example.universitySE.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretaryService implements SecretaryServiceInterface {

    @Autowired
    SecretaryRepository secretaryRepository;

    @Override
    public void savePerson(PersonDTO personDTO) {

        Person person = new Person(personDTO.getId(), personDTO.getUsername(), personDTO.getPassword(), personDTO.getPersonType());
        secretaryRepository.save(person);
    }

    @Override
    public void saveSecretary(SecretaryDTO secretaryDTO) {

        Secretary secretary = new Secretary(secretaryDTO.getId(), secretaryDTO.getFaculty(), secretaryDTO.getVenue());
        secretaryRepository.save(secretary);
    }

    @Override
    public void saveProfessor(ProfessorDTO professorDTO) {

        Professor professor = new Professor(professorDTO.getId(), professorDTO.getFirstName(), professorDTO.getLastName(), professorDTO.getBiography(), professorDTO.getReceptionTime(), professorDTO.getSubject());
        secretaryRepository.save(professor);
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {

        Student student = new Student(studentDTO.getId(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getDateOfBirth(), studentDTO.getBadgeNumber(), studentDTO.getStudyCourse(), studentDTO.getEnrollmentYear());
        secretaryRepository.save(student);
    }

    @Override
    public void saveStudyCourse(StudyCourseDTO studyCourseDTO) {

        StudyCourse studyCourse = new StudyCourse(studyCourseDTO.getId(), studyCourseDTO.getName(), studyCourseDTO.getFaculty());
        secretaryRepository.save(studyCourse);
    }

    @Override
    public void saveSubject(SubjectDTO subjectDTO) {

        Subject subject = new Subject(subjectDTO.getId(), subjectDTO.getName(), subjectDTO.getStudyCourse(), subjectDTO.getYearCourse());
        secretaryRepository.save(subject);
    }

    @Override
    public void saveClassroom(ClassroomDTO classroomDTO) {

        Classroom classroom = new Classroom(classroomDTO.getId(), classroomDTO.getName(), classroomDTO.getLatitude(), classroomDTO.getLongitude());
        secretaryRepository.save(classroom);
    }

    @Override
    public void saveActivity(ActivityDTO activityDTO) {

        Activity activity = new Activity(activityDTO.getId(), activityDTO.getStudyCourse(), activityDTO.getSubject(), activityDTO.getIdProf(), activityDTO.getStart(), activityDTO.getEnd(), activityDTO.getClassroomName(), activityDTO.getActivityType());
        secretaryRepository.save(activity);
    }

    @Override
    public void saveExam(ExamDTO examDTO) {

        Exam exam = new Exam(examDTO.getId());
        secretaryRepository.save(exam);
    }

    @Override
    public void saveLesson(LessonDTO lessonDTO) {

        Lesson lesson = new Lesson(lessonDTO.getId());
        secretaryRepository.save(lesson);
    }

}
