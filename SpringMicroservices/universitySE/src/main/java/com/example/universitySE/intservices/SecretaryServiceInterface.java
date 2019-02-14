package com.example.universitySE.intservices;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.*;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.models.*;

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

    void saveCarryoutActivity(CarryoutActivityDTO carryoutActivityDTO) throws CarryoutActivityException;

    // -------------------------- UPDATE METHODS

    void updateReporting(ReportingRetDTO reportingRetDTO) throws ReportingException;

    void updateCarryoutActivity(CarryoutActivityDTO carryoutActivityDTO) throws CarryoutActivityException;

    // ------------------------- RETURN MODEL METHODS

    FacultyModel getFaculty(long id) throws FacultyException;

    PersonTypeModel getPersonType(long id) throws PersonTypeException;

    ActivityTypeModel getActivityType(long id) throws ActivityTypeException;

    StateModel getState(long id) throws StateException;

    SupportMaterialModel getSupportMaterial(long id) throws SupportMaterialException;

    ActivityModel getActivity(long id) throws ActivityException;

    PersonModel getPerson(long id) throws PersonException;

    ProfessorModel getProfessor(long id) throws ProfessorException;

    ClassroomModel getClassroom(long id) throws ClassroomException;

    ReportModel getReporting(long id) throws ReportingException;

    SecretaryRetModel getSecretary(long id) throws SecretaryException, FacultyException;

    StudyCourseModel getStudyCourse(long id) throws StudyCourseException, FacultyException;

    SubjectCalendarModel getSubject(long id) throws SubjectException;

    ProfessorCalendarModel getProfessorCalendar(long id) throws ProfessorException;

    ActivityTypeCalendarModel getActivityTypeCalendar(long id) throws ActivityTypeException;

    ActivityCalendarModel getActivityCalendar(long id) throws ActivityException, ActivityTypeException;

    CarryoutActivityRetModel getCarryoutActivity(long id) throws CarryoutActivityException, ActivityTypeException, ActivityException, ClassroomException,
            StudyCourseException, FacultyException, SubjectException, ProfessorException;

    CarryoutActivityModel getCarryoutActivityModel(long id) throws CarryoutActivityException;

    CarryoutActivityCalendarModel getCarryoutActivityCalendar(long id) throws CarryoutActivityException, ActivityTypeException, ActivityException, ClassroomException,
            StudyCourseException, FacultyException, SubjectException, ProfessorException;

    // ------------------------- RETURN LIST METHODS

    List<StudyCourse> getStudyCourses(long faculty) throws StudyCourseException;

    List<Subject> getSubjects(int study_course) throws SubjectException;

    List<Professor> getProfessors(int subject) throws ProfessorException;

    List<Classroom> getClassrooms() throws ClassroomException;

    List<PersonType> getPersonTypes() throws PersonTypeException;

    List<ActivityType> getActivityTypes() throws ActivityTypeException;

    List<State> getStates() throws StateException;

    List<SupportMaterial> getSupportMaterials() throws SupportMaterialException;

    // List<Reporting> getReportings() throws ReportingException;
    List<ReportingRetModel> getReportingsIterator() throws ReportingException, SupportMaterialException, StateException, ProfessorException,
            ClassroomException, SecretaryException, FacultyException;

    List<CarryoutActivityRetModel> getCarryoutActivities() throws CarryoutActivityException, ProfessorException, ActivityTypeException, FacultyException,
            ClassroomException, SubjectException, StudyCourseException, ActivityException;

    List<ActivityWithoutClassroomModel> getActivitiesWithoutClassroom() throws ActivityException, StudyCourseException, FacultyException, SubjectException,
            ProfessorException, ActivityTypeException;

    List<CarryoutActivityCalendarModel> getCarryoutActivitiesCalendar() throws CarryoutActivityException, ProfessorException, ActivityTypeException, FacultyException,
            ClassroomException, SubjectException, StudyCourseException, ActivityException;

    List<CarryoutActivityCalendarModel> getTodayCarryoutActivitiesCalendar() throws CarryoutActivityException, ProfessorException, ActivityTypeException, FacultyException,
            ClassroomException, SubjectException, StudyCourseException, ActivityException;
}
