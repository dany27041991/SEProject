package com.example.universitySE.intservices;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.*;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.models.*;

import java.util.Date;
import java.util.List;

public interface SecretaryServiceInterface {

    // ---------------------- SAVE METHODS

    void savePerson(PersonDTO personDTO) throws PersonException;
    long savePersonRet(PersonDTO personDTO) throws PersonException;

    void saveSecretary(SecretaryDTO secretaryDTO) throws SecretaryException;

    void saveProfessor(ProfessorDTO professorDTO) throws ProfessorException, PersonException;

    void saveStudent(StudentDTO studentDTO) throws StudentException, PersonException;

    void saveStudyCourse(StudyCourseDTO studyCourseDTO) throws StudyCourseException;

    void saveSubject(SubjectDTO subjectDTO) throws SubjectException;

    void saveClassroom(ClassroomDTO classroomDTO) throws ClassroomException;

    void saveActivity(ActivityDTO activityDTO) throws ActivityException;
    long saveActivityRet(ActivityDTO activityDTO) throws ActivityException;

    void saveExam(ExamDTO examDTO) throws ExamException, ActivityException;

    void saveLesson(LessonDTO lessonDTO) throws LessonException, ActivityException;

    // ------------------------- RETURN MODEL METHODS

    FacultyModel getFaculty(long id) throws FacultyException;

    PersonTypeModel getPersonType(long id) throws PersonTypeException;

    ActivityTypeModel getActivityType(long id) throws ActivityTypeException;

    StateModel getState(long id) throws StateException;

    SupportMaterialModel getSupportMaterial(long id) throws SupportMaterialException;

    // ActivityModel getActivity(int study_course, int subject, int id_prof, Date start, Date end, int activity_type) throws ActivityException;
    ActivityModel getActivity(long id) throws ActivityException;

    // PersonModel getPerson(String username, String password, int person_type) throws PersonException;
    PersonModel getPerson(long id) throws PersonException;


    // ------------------------- RETURN LIST METHODS

    List<StudyCourse> getStudyCourses(long faculty) throws StudyCourseException;

    List<Subject> getSubjects(int study_course) throws SubjectException;

    List<Professor> getProfessors(int subject) throws ProfessorException;

    List<Classroom> getClassrooms() throws ClassroomException;

    List<PersonType> getPersonTypes() throws PersonTypeException;

    List<ActivityType> getActivityTypes() throws ActivityTypeException;

    List<State> getStates() throws StateException;

    List<SupportMaterial> getSupportMaterials() throws SupportMaterialException;
}
