package com.example.universitySE.intservices;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.*;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class SecretaryServiceInterfaceTest {

    @Mock
    SecretaryServiceInterface secretaryServiceInterface = mock(SecretaryServiceInterface.class);

    @Test
    public void savePerson() throws PersonException {
        PersonDTO personDTO = mock(PersonDTO.class);
        secretaryServiceInterface.savePerson(personDTO);
    }

    @Test
    public void savePersonRet() {
    }

    @Test
    public void saveProfessor() throws PersonException, ProfessorException {
        ProfessorDTO professorDTO = mock(ProfessorDTO.class);
        secretaryServiceInterface.saveProfessor(professorDTO);
    }

    @Test
    public void saveStudent() throws PersonException, StudentException {
        StudentDTO studentDTO = mock(StudentDTO.class);
        secretaryServiceInterface.saveStudent(studentDTO);
    }

    @Test
    public void saveStudyCourse() throws StudyCourseException {
        StudyCourseDTO studyCourseDTO = mock(StudyCourseDTO.class);
        secretaryServiceInterface.saveStudyCourse(studyCourseDTO);
    }

    @Test
    public void saveSubject() throws SubjectException {
        SubjectDTO subjectDTO = mock(SubjectDTO.class);
        secretaryServiceInterface.saveSubject(subjectDTO);
    }

    @Test
    public void saveClassroom() throws ClassroomException {
        ClassroomDTO classroomDTO = mock(ClassroomDTO.class);
        secretaryServiceInterface.saveClassroom(classroomDTO);
    }

    @Test
    public void saveActivity() throws ActivityException {
        ActivityDTO activityDTO = mock(ActivityDTO.class);
        secretaryServiceInterface.saveActivity(activityDTO);
    }

    @Test
    public void saveActivityRet() {
    }

    @Test
    public void saveExam() throws ExamException, ActivityException {
        ExamDTO examDTO = mock(ExamDTO.class);
        secretaryServiceInterface.saveExam(examDTO);
    }

    @Test
    public void saveLesson() throws LessonException, ActivityException {
        LessonDTO lessonDTO = mock(LessonDTO.class);
        secretaryServiceInterface.saveLesson(lessonDTO);
    }

    @Test
    public void saveCarryoutActivity() throws CarryoutActivityException {
        CarryoutActivityDTO carryoutActivityDTO = mock(CarryoutActivityDTO.class);
        secretaryServiceInterface.saveCarryoutActivity(carryoutActivityDTO);
    }

    @Test
    public void updateReporting() throws ReportingException {
        ReportingRetDTO reportingRetDTO = mock(ReportingRetDTO.class);
        secretaryServiceInterface.updateReporting(reportingRetDTO);
    }

    @Test
    public void updateCarryoutActivity() throws CarryoutActivityException {
        CarryoutActivityDTO carryoutActivityDTO = mock(CarryoutActivityDTO.class);
        secretaryServiceInterface.updateCarryoutActivity(carryoutActivityDTO);
    }

    @Test
    public void getFaculty() throws FacultyException {
        FacultyModel facultyModel = mock(FacultyModel.class);
        facultyModel.setId(1);
        facultyModel.setName("name test");
        when(secretaryServiceInterface.getFaculty(1)).thenReturn(facultyModel);

        FacultyModel facultyModel1 = secretaryServiceInterface.getFaculty(1);
        assertEquals(facultyModel1, facultyModel);
    }

    @Test
    public void getPersonType() throws PersonTypeException {
        PersonTypeModel personTypeModel = mock(PersonTypeModel.class);
        personTypeModel.setId(1);
        personTypeModel.setName("name test");
        when(secretaryServiceInterface.getPersonType(1)).thenReturn(personTypeModel);

        PersonTypeModel personTypeModel1 = secretaryServiceInterface.getPersonType(1);
        assertEquals(personTypeModel1, personTypeModel);
    }

    @Test
    public void getActivityType() throws ActivityTypeException {
        ActivityTypeModel activityTypeModel = mock(ActivityTypeModel.class);
        activityTypeModel.setId(1);
        activityTypeModel.setName("name test");
        when(secretaryServiceInterface.getActivityType(1)).thenReturn(activityTypeModel);

        ActivityTypeModel activityTypeModel1 = mock(ActivityTypeModel.class);
        activityTypeModel1.setId(1);
        activityTypeModel1.setName("name test");
        assertEquals(activityTypeModel1.getId(), activityTypeModel.getId());
        assertEquals(activityTypeModel1.getName(), activityTypeModel.getName());
    }

    @Test
    public void getState() throws StateException {
        StateModel stateModel = mock(StateModel.class);
        stateModel.setId(1);
        stateModel.setName("name test");
        when(secretaryServiceInterface.getState(1)).thenReturn(stateModel);

        StateModel stateModel1 = secretaryServiceInterface.getState(1);
        assertEquals(stateModel1, stateModel);
    }

    @Test
    public void getSupportMaterial() throws SupportMaterialException {
        SupportMaterialModel supportMaterialModel = mock(SupportMaterialModel.class);
        supportMaterialModel.setId(1);
        supportMaterialModel.setName("name test");
        when(secretaryServiceInterface.getSupportMaterial(1)).thenReturn(supportMaterialModel);

        SupportMaterialModel supportMaterialModel1 = secretaryServiceInterface.getSupportMaterial(1);
        assertEquals(supportMaterialModel1, supportMaterialModel);
    }

    @Test
    public void getActivity() {
    }

    @Test
    public void getPerson() {
    }

    @Test
    public void getProfessor() {
    }

    @Test
    public void getClassroom() {
    }

    @Test
    public void getReporting() {
    }

    @Test
    public void getSecretary() {
    }

    @Test
    public void getStudyCourse() {
    }

    @Test
    public void getSubject() {
    }

    @Test
    public void getProfessorCalendar() {
    }

    @Test
    public void getActivityTypeCalendar() {
    }

    @Test
    public void getActivityCalendar() {
    }

    @Test
    public void getCarryoutActivity() {
    }

    @Test
    public void getCarryoutActivityModel() {
    }

    @Test
    public void getCarryoutActivityCalendar() {
    }

    @Test
    public void getStudyCourses() throws StudyCourseException {
        StudyCourse studyCourse = mock(StudyCourse.class);
        List<StudyCourse> studyCourseList = new ArrayList<>();
        studyCourseList.add(studyCourse);
        when(secretaryServiceInterface.getStudyCourses(1)).thenReturn(studyCourseList);

        List<StudyCourse> studyCourses = secretaryServiceInterface.getStudyCourses(1);
        assertEquals(studyCourseList, studyCourses);
    }

    @Test
    public void getSubjects() throws SubjectException {
        Subject subject = mock(Subject.class);
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        when(secretaryServiceInterface.getSubjects(1)).thenReturn(subjects);

        List<Subject> subjects1 = secretaryServiceInterface.getSubjects(1);
        assertEquals(subjects1, subjects);
    }

    @Test
    public void getProfessors() throws ProfessorException {
        Professor professor = mock(Professor.class);
        List<Professor> professors = new ArrayList<>();
        professors.add(professor);
        when(secretaryServiceInterface.getProfessors(1)).thenReturn(professors);

        List<Professor> professors1 = secretaryServiceInterface.getProfessors(1);
        assertEquals(professors1, professors);
    }

    @Test
    public void getClassrooms() throws ClassroomException {
        Classroom classroom = mock(Classroom.class);
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroom);
        when(secretaryServiceInterface.getClassrooms()).thenReturn(classrooms);

        List<Classroom> classrooms1 = secretaryServiceInterface.getClassrooms();
        assertEquals(classrooms1, classrooms);
    }

    @Test
    public void getPersonTypes() throws PersonTypeException {
        PersonType personType = mock(PersonType.class);
        List<PersonType> personTypes = new ArrayList<>();
        personTypes.add(personType);
        when(secretaryServiceInterface.getPersonTypes()).thenReturn(personTypes);

        List<PersonType> personTypes1 = secretaryServiceInterface.getPersonTypes();
        assertEquals(personTypes1, personTypes);
    }

    @Test
    public void getActivityTypes() {
    }

    @Test
    public void getStates() {
    }

    @Test
    public void getSupportMaterials() {
    }

    @Test
    public void getReportingsIterator() {
    }

    @Test
    public void getCarryoutActivities() {
    }

    @Test
    public void getActivitiesWithoutClassroom() {
    }

    @Test
    public void getCarryoutActivitiesCalendar() {
    }

    @Test
    public void getTodayCarryoutActivitiesCalendar() {
    }

    @Test
    public void getStudent() {
    }

    @Test
    public void getNotificationActivitiesSubject() {
    }

    @Test
    public void getNotificationActivitiesStudyCourse() {
    }

    @Test
    public void getNotificationReportingsProfessor() {
    }

    @Test
    public void getNotificationCarryoutActivitySubject() {
    }

    @Test
    public void getNotificationCarryoutActivityStudyCourse() {
    }

    @Test
    public void getNotificationReportingProfessor() {
    }

    @Test
    public void getIterator() {
    }

}