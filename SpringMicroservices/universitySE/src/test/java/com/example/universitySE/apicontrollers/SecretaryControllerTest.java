package com.example.universitySE.apicontrollers;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.*;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.intservices.SecretaryServiceInterface;
import com.example.universitySE.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = SecretaryController.class, secure = false)
public class SecretaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LoginServiceInterface loginServiceInterface;

    @MockBean
    SecretaryServiceInterface secretaryServiceInterface;

    @Test
    public void addPerson() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        PersonDTO personDTO = mock(PersonDTO.class);
        secretaryServiceInterface.savePerson(personDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/insertperson", personDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(personDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void addStudyCourse() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        StudyCourseDTO studyCourseDTO = mock(StudyCourseDTO.class);
        secretaryServiceInterface.saveStudyCourse(studyCourseDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/insertstudycourse", studyCourseDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(studyCourseDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void addSubject() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        SubjectDTO subjectDTO = mock(SubjectDTO.class);
        secretaryServiceInterface.saveSubject(subjectDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/insertsubject", subjectDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(subjectDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void addClassroom() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ClassroomDTO classroomDTO = mock(ClassroomDTO.class);
        secretaryServiceInterface.saveClassroom(classroomDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/insertclassroom", classroomDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(classroomDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void addActivity() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ActivityDTO activityDTO = mock(ActivityDTO.class);
        secretaryServiceInterface.saveActivity(activityDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/insertactivity", activityDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(activityDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void addCarryoutActivity() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        CarryoutActivityDTO carryoutActivityDTO = mock(CarryoutActivityDTO.class);
        secretaryServiceInterface.saveCarryoutActivity(carryoutActivityDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/insertcarryoutactivity", carryoutActivityDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(carryoutActivityDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void updateReporting() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ReportingRetDTO reportingRetDTO = mock(ReportingRetDTO.class);
        secretaryServiceInterface.updateReporting(reportingRetDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/updatereporting", reportingRetDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(reportingRetDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void updateCarryoutActivity() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        CarryoutActivityDTO carryoutActivityDTO = mock(CarryoutActivityDTO.class);
        secretaryServiceInterface.updateCarryoutActivity(carryoutActivityDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8090/user/secretary/updatecarryoutactivity", carryoutActivityDTO)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(carryoutActivityDTO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }

    @Test
    public void getFaculty() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        FacultyModel facultyModel = mock(FacultyModel.class);
        facultyModel.setId(1);
        facultyModel.setName("faculty test");
        when(secretaryServiceInterface.getFaculty(1)).thenReturn(facultyModel);

        assertNotEquals(2, facultyModel.getId());
        assertNotEquals("test", facultyModel.getName());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/faculty/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getPersonType() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        PersonTypeModel personTypeModel = mock(PersonTypeModel.class);
        personTypeModel.setId(1);
        personTypeModel.setName("person type test");
        when(secretaryServiceInterface.getPersonType(1)).thenReturn(personTypeModel);

        assertNotEquals(2, personTypeModel.getId());
        assertNotEquals("test", personTypeModel.getName());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/persontype/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getActivityType() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ActivityTypeModel activityTypeModel = mock(ActivityTypeModel.class);
        activityTypeModel.setId(1);
        activityTypeModel.setName("activity type test");
        when(secretaryServiceInterface.getActivityType(1)).thenReturn(activityTypeModel);

        assertNotEquals(2, activityTypeModel.getId());
        assertNotEquals("test", activityTypeModel.getName());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/activitytype/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getState() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        StateModel stateModel = mock(StateModel.class);
        stateModel.setId(1);
        stateModel.setName("state test");
        when(secretaryServiceInterface.getState(1)).thenReturn(stateModel);

        assertNotEquals(2, stateModel.getId());
        assertNotEquals("test", stateModel.getName());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/state/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getSupportMaterial() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        SupportMaterialModel supportMaterialModel = mock(SupportMaterialModel.class);
        supportMaterialModel.setId(1);
        supportMaterialModel.setName("support material test");
        when(secretaryServiceInterface.getSupportMaterial(1)).thenReturn(supportMaterialModel);

        assertNotEquals(2, supportMaterialModel.getId());
        assertNotEquals("test", supportMaterialModel.getName());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/supportmaterial/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getProfessor() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        ProfessorModel professorModel = mock(ProfessorModel.class);
        professorModel.setId(1);
        professorModel.setUsername("username");
        professorModel.setFirstname("firstname");
        professorModel.setLastname("lastname");
        professorModel.setPerson_type(2);
        professorModel.setBiography("biography");
        professorModel.setReceptiontime("time");
        professorModel.setSubject(1);
        professorModel.setDateOfBirth(new Date());
        when(secretaryServiceInterface.getProfessor(1)).thenReturn(professorModel);

        ProfessorModel professorModel1 = mock(ProfessorModel.class);
        professorModel1.setId(1);
        professorModel1.setUsername("username");
        professorModel1.setFirstname("firstname");
        professorModel1.setLastname("lastname");
        professorModel1.setPerson_type(2);
        professorModel1.setBiography("biography");
        professorModel1.setReceptiontime("time");
        professorModel1.setSubject(1);
        professorModel1.setDateOfBirth(new Date());

        assertEquals(professorModel1.getId(), professorModel.getId());
        assertEquals(professorModel1.getUsername(), professorModel.getUsername());
        assertEquals(professorModel1.getFirstname(), professorModel.getFirstname());
        assertEquals(professorModel1.getLastname(), professorModel.getLastname());
        assertEquals(professorModel1.getPerson_type(), professorModel.getPerson_type());
        assertEquals(professorModel1.getBiography(), professorModel.getBiography());
        assertEquals(professorModel1.getReceptiontime(), professorModel.getReceptiontime());
        assertEquals(professorModel1.getDateOfBirth(), professorModel.getDateOfBirth());
        assertEquals(professorModel1.getSubject(), professorModel.getSubject());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/professor/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getClassroom() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getSecretary() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getStudyCourses() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        StudyCourse studyCourse = mock(StudyCourse.class);
        List<StudyCourse> studyCourses = new ArrayList<>();
        studyCourses.add(studyCourse);
        when(secretaryServiceInterface.getStudyCourses(1)).thenReturn(studyCourses);

        StudyCourse studyCourse1 = mock(StudyCourse.class);
        List<StudyCourse> studyCourses1 = new ArrayList<>();
        studyCourses1.add(studyCourse1);
        assertNotEquals(studyCourse, studyCourse1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/courses/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getSubjects() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        Subject subject = mock(Subject.class);
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        when(secretaryServiceInterface.getSubjects(1)).thenReturn(subjects);

        Subject subject1 = mock(Subject.class);
        List<Subject> subjects1 = new ArrayList<>();
        subjects1.add(subject1);
        assertNotEquals(subject, subject1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/subjects/1", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getProfessors() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getClassrooms() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

        Classroom classroom = mock(Classroom.class);
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroom);
        when(secretaryServiceInterface.getClassrooms()).thenReturn(classrooms);

        List<Classroom> classrooms1 = new ArrayList<>();
        classrooms1.add(classroom);
        assertEquals(classrooms, classrooms1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8090/user/secretary/classrooms", Integer.class)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getPersonTypes() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);

    }

    @Test
    public void getActivityTypes() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getStates() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getSupportMaterials() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getReportings() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getCarryoutActivities() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getActivitiesWithoutClassroom() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getCarryoutActivitiesCalendar() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getTodayCarryoutActivitiesCalendar() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(loginServiceInterface.verifyJwtAndGetData(httpServletRequest)).thenThrow(InvalidUseOfMatchersException.class);
    }

    @Test
    public void getNotificationCarryoutActivitySubject() throws Exception {
    }

    @Test
    public void getNotificationCarryoutActivityStudyCourse() throws Exception {
    }

    @Test
    public void getNotificationReportingProfessor() throws Exception {
    }

    @Test
    public void getProfessorDetails() throws Exception {
    }

    @Test
    public void getStudentDetails() throws Exception {
    }
}