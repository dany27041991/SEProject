package com.example.universitySE.intservices;

import com.example.universitySE.dtos.*;

public interface SecretaryServiceInterface {

    void savePerson(PersonDTO personDTO);

    void saveSecretary(SecretaryDTO secretaryDTO);

    void saveProfessor(ProfessorDTO professorDTO);

    void saveStudent(StudentDTO studentDTO);

    void saveStudyCourse(StudyCourseDTO studyCourseDTO);

    void saveSubject(SubjectDTO subjectDTO);

    void saveClassroom(ClassroomDTO classroomDTO);

    void saveActivity(ActivityDTO activityDTO);

    void saveExam(ExamDTO examDTO);

    void saveLesson(LessonDTO lessonDTO);
}
