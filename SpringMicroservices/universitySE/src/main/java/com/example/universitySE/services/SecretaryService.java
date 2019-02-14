package com.example.universitySE.services;

import com.example.universitySE.domain.*;
import com.example.universitySE.dtos.*;
import com.example.universitySE.exceptions.*;
import com.example.universitySE.intservices.Container;
import com.example.universitySE.intservices.Iterator;
import com.example.universitySE.intservices.SecretaryServiceInterface;
import com.example.universitySE.models.*;
import com.example.universitySE.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService implements SecretaryServiceInterface, Container {

    private static final Logger log = LoggerFactory.getLogger(SecretaryServiceInterface.class);

    @Autowired
    SecretaryRepository secretaryRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    StudyCourseRepository studyCourseRepository;

    @Autowired
    PersonTypeRepository personTypeRepository;

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    SupportMaterialRepository supportMaterialRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ReportingRepository reportingRepository;

    @Autowired
    CarryoutActivityRepository carryoutActivityRepository;

    // -------------------------------------------- SAVE METHODS

    @Override
    public void savePerson(PersonDTO personDTO) throws PersonException {

        if (!personDTO.equals(null)) {

            Person person = new Person(personDTO.getUsername(), personDTO.getPassword(), personDTO.getPersonType());
            secretaryRepository.save(person);
            log.info("added new person");
        }
        else {

            log.info("could not add new person");
            throw new PersonException("could not add new person");
        }
    }

    @Override
    public long savePersonRet(PersonDTO personDTO) throws PersonException {

        if (!personDTO.equals(null)) {

            Person person = new Person(personDTO.getUsername(), personDTO.getPassword(), personDTO.getPersonType());
            secretaryRepository.save(person);
            long id = person.getId();
            log.info("added new person");
            return id;
        }
        else {

            log.info("could not add new person");
            throw new PersonException("could not add new person");
        }
    }

    @Override
    public void saveSecretary(SecretaryDTO secretaryDTO) throws SecretaryException {

        if (!secretaryDTO.equals(null)) {

            Secretary secretary = new Secretary(secretaryDTO.getId(), secretaryDTO.getFaculty(), secretaryDTO.getVenue());
            secretaryRepository.save(secretary);
            log.info("added new secretary");
        }
        else {

            log.info("could not add new secretary");
            throw new SecretaryException("could not add new secretary");
        }
    }

    @Override
    public void saveProfessor(ProfessorDTO professorDTO) throws ProfessorException, PersonException {

        if (!professorDTO.equals(null)) {
            PersonModel personModel = getPerson(professorDTO.getId());
            Professor professor = new Professor(personModel.getId(), professorDTO.getFirstName(), professorDTO.getLastName(), professorDTO.getBiography(), professorDTO.getReceptionTime(), professorDTO.getSubject(), professorDTO.getDateOfBirth());
            secretaryRepository.save(professor);
            log.info("added new professor");
        }
        else {

            log.info("could not add new professor");
            throw new ProfessorException("could not add new professor");
        }
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) throws StudentException, PersonException {

        if (!studentDTO.equals(null)) {
            PersonModel personModel = getPerson(studentDTO.getId());
            Student student = new Student(personModel.getId(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getDateOfBirth(), studentDTO.getBadgeNumber(), studentDTO.getStudyCourse(), studentDTO.getEnrollmentYear());
            secretaryRepository.save(student);
            log.info("added new student");
        }
        else {

            log.info("could not add new student");
            throw new StudentException("could not add new student");
        }
    }

    @Override
    public void saveStudyCourse(StudyCourseDTO studyCourseDTO) throws StudyCourseException {

        if (!studyCourseDTO.equals(null)) {

            StudyCourse studyCourse = new StudyCourse(studyCourseDTO.getName(), studyCourseDTO.getFaculty());
            secretaryRepository.save(studyCourse);
            log.info("added new course of study");
        }
        else {

            log.info("could not add new course of study");
            throw new StudyCourseException("could not add new course of study");
        }
    }

    @Override
    public void saveSubject(SubjectDTO subjectDTO) throws SubjectException {

        if (!subjectDTO.equals(null)) {

            Subject subject = new Subject(subjectDTO.getName(), subjectDTO.getStudyCourse(), subjectDTO.getYearCourse());
            secretaryRepository.save(subject);
            log.info("added new subject");
        }
        else {

            log.info("could not add new subject");
            throw new SubjectException("could not add new subject");
        }
    }

    @Override
    public void saveClassroom(ClassroomDTO classroomDTO) throws ClassroomException {

        if (!classroomDTO.equals(null)) {

            Classroom classroom = new Classroom(classroomDTO.getName(), classroomDTO.getLatitude(), classroomDTO.getLongitude());
            secretaryRepository.save(classroom);
            log.info("added new classroom");
        }
        else {

            log.info("could not add new classroom");
            throw new ClassroomException("could not add new classroom");
        }
    }

    @Override
    public void saveActivity(ActivityDTO activityDTO) throws ActivityException {

        if (!activityDTO.equals(null)) {

            Activity activity = new Activity(activityDTO.getStudyCourse(), activityDTO.getSubject(), activityDTO.getIdProf(), activityDTO.getStart(), activityDTO.getEnd(), activityDTO.getActivityType());
            secretaryRepository.save(activity);
            log.info("added new activity");
        }
        else {

            log.info("could not add new activity");
            throw new ActivityException("could not add new activity");
        }

    }

    @Override
    public long saveActivityRet(ActivityDTO activityDTO) throws ActivityException {

        if (!activityDTO.equals(null)) {

            Activity activity = new Activity(activityDTO.getStudyCourse(), activityDTO.getSubject(), activityDTO.getIdProf(), activityDTO.getStart(), activityDTO.getEnd(), activityDTO.getActivityType());
            secretaryRepository.save(activity);
            long id = activity.getId();
            log.info("added new activity");
            return id;
        }
        else {

            log.info("could not add new activity");
            throw new ActivityException("could not add new activity");
        }
    }

    @Override
    public void saveExam(ExamDTO examDTO) throws ExamException, ActivityException {

        if (!examDTO.equals(null)) {

            ActivityModel activityModel = getActivity(examDTO.getId());
            Exam exam = new Exam(activityModel.getId());
            secretaryRepository.save(exam);
            log.info("added new exam");
        }
        else {

            log.info("could not add new exam");
            throw new ExamException("could not add new exam");
        }
    }

    @Override
    public void saveLesson(LessonDTO lessonDTO) throws LessonException, ActivityException {

        if (!lessonDTO.equals(null)) {

            ActivityModel activityModel = getActivity(lessonDTO.getId());
            Lesson lesson = new Lesson(activityModel.getId());
            secretaryRepository.save(lesson);
            log.info("added new lesson");
        }
        else {

            log.info("could not add new lesson");
            throw new LessonException("could not add new lesson");
        }
    }

    @Override
    public void saveCarryoutActivity(CarryoutActivityDTO carryoutActivityDTO) throws CarryoutActivityException {

        if(!carryoutActivityDTO.equals(null)) {

            CarryoutActivity carryoutActivity = new CarryoutActivity(carryoutActivityDTO.getId(), carryoutActivityDTO.getIdActivity(), carryoutActivityDTO.getClassroomName());
            secretaryRepository.save(carryoutActivity);
            log.info("added new carryout activity");
        }
        else {

            log.info("could not add new carryout activity");
            throw new CarryoutActivityException("could not add new carryout activity");
        }
    }


    // -------------------------------- UPDATE METHODS

    @Override
    public void updateReporting(ReportingRetDTO reportingRetDTO) throws ReportingException {

        if (!reportingRetDTO.equals(null)) {

            ReportModel reportModel = getReporting(reportingRetDTO.getId());
            Reporting reporting = new Reporting(reportModel.getId(), reportingRetDTO.getNoteProf(), reportingRetDTO.getSupportMaterial(), reportingRetDTO.getNoteSec(),
                    reportingRetDTO.getState(), reportingRetDTO.getProfessor(), reportingRetDTO.getSecretary(), reportingRetDTO.getClassroom());
            secretaryRepository.save(reporting);
            log.info("reporting updated");
        }
        else {

            log.info("could not update reporting");
            throw new ReportingException("could not update reporting");
        }
    }

    @Override
    public void updateCarryoutActivity(CarryoutActivityDTO carryoutActivityDTO) throws CarryoutActivityException {

        if (!carryoutActivityDTO.equals(null)) {

            CarryoutActivityModel carryoutActivityModel = getCarryoutActivityModel(carryoutActivityDTO.getId());
            CarryoutActivity carryoutActivity = new CarryoutActivity(carryoutActivityModel.getId(), carryoutActivityModel.getIdActivity(), carryoutActivityDTO.getClassroomName());
            secretaryRepository.save(carryoutActivity);
            log.info("carryout activity updated");
        }
        else {

            log.info("could not update carryout activity");
            throw new CarryoutActivityException("could not update carryout activity");
        }
    }

    // ---------------------------------- RETURN MODEL METHODS

    @Override
    public FacultyModel getFaculty(long id) throws FacultyException {

        Optional<Faculty> faculty = facultyRepository.findFacultyById(id);
        if (faculty.isPresent()) {

            log.info("faculty found");
            Faculty facultyReturned = faculty.get();
            FacultyModel facultyModel = new FacultyModel(facultyReturned.getId(), facultyReturned.getName());
            return facultyModel;
        }
        else {

            log.info("faculty not found");
            throw new FacultyException("faculty not found");
        }
    }

    @Override
    public PersonTypeModel getPersonType(long id) throws PersonTypeException {

        Optional<PersonType> personType = personTypeRepository.findPersonTypeById(id);
        if (personType.isPresent()) {

            log.info("person type found");
            PersonType personTypeReturned = personType.get();
            PersonTypeModel personTypeModel = new PersonTypeModel(personTypeReturned.getId(), personTypeReturned.getName());
            return personTypeModel;
        }
        else {

            log.info("person type not found");
            throw new PersonTypeException("person type not found");
        }
    }

    @Override
    public ActivityTypeModel getActivityType(long id) throws ActivityTypeException {

        Optional<ActivityType> activityType = activityTypeRepository.findActivityTypeById(id);
        if (activityType.isPresent()) {

            log.info("activity type found");
            ActivityType activityTypeReturned = activityType.get();
            ActivityTypeModel activityTypeModel = new ActivityTypeModel(activityTypeReturned.getId(), activityTypeReturned.getName());
            return activityTypeModel;
        }
        else {

            log.info("activity type not found");
            throw new ActivityTypeException("activity type not found");
        }
    }

    @Override
    public StateModel getState(long id) throws StateException {

        Optional<State> state = stateRepository.findStateById(id);
        if (state.isPresent()) {

            log.info("state found");
            State stateReturned = state.get();
            StateModel stateModel = new StateModel(stateReturned.getId(), stateReturned.getName());
            return stateModel;
        }
        else {

            log.info("state not found");
            throw new StateException("state not found");
        }
    }

    @Override
    public SupportMaterialModel getSupportMaterial(long id) throws SupportMaterialException {

        Optional<SupportMaterial> supportMaterial = supportMaterialRepository.findSupportMaterialById(id);
        if (supportMaterial.isPresent()) {

            log.info("support material found");
            SupportMaterial supportMaterialReturned = supportMaterial.get();
            SupportMaterialModel supportMaterialModel = new SupportMaterialModel(supportMaterialReturned.getId(), supportMaterialReturned.getName());
            return supportMaterialModel;
        }
        else {

            log.info("support material not found");
            throw new SupportMaterialException("support material not found");
        }
    }

    @Override
    public ActivityModel getActivity(long id) throws ActivityException {

        Optional<Activity> activity = activityRepository.findActivityById(id);
        if (activity.isPresent()) {

            log.info("activity found");
            Activity activityReturned = activity.get();
            ActivityModel activityModel = new ActivityModel(activityReturned.getId(), activityReturned.getStudyCourse(), activityReturned.getSubject(), activityReturned.getIdProf(),
                    activityReturned.getStart(), activityReturned.getEnd(), activityReturned.getActivityType());
            return activityModel;
        }
        else {

            log.info("activity not found");
            throw new ActivityException("activity not found");
        }
    }

    @Override
    public PersonModel getPerson(long id) throws PersonException {

        Optional<Person> person = personRepository.findPersonById(id);
        if (person.isPresent()) {

            log.info("person found");
            Person personReturned = person.get();
            PersonModel personModel = new PersonModel(personReturned.getId(), personReturned.getUsername(), personReturned.getPassword(), personReturned.getPersonType());
            return personModel;
        }
        else {

            log.info("person not found");
            throw new PersonException("person not found");
        }
    }

    @Override
    public ProfessorModel getProfessor(long id) throws ProfessorException {

        Optional<Professor> professor = professorRepository.findProfessorById(id);
        if (professor.isPresent()) {

            log.info("professor found");
            Professor professorReturned = professor.get();
            ProfessorModel professorModel = new ProfessorModel(professorReturned.getId(), professorReturned.getFirstName(), professorReturned.getLastName(), professorReturned.getBiography(),
                    professorReturned.getReceptionTime(), professorReturned.getSubject(), professorReturned.getDateOfBirth());
            return professorModel;
        }
        else {

            log.info("professor not found");
            throw new ProfessorException("professor not found");
        }
    }

    @Override
    public ClassroomModel getClassroom(long id) throws ClassroomException {

        Optional<Classroom> classroom = classroomRepository.findClassroomById(id);
        if (classroom.isPresent()) {

            log.info("classroom found");
            Classroom classroomReturned = classroom.get();
            ClassroomModel classroomModel = new ClassroomModel(classroomReturned.getId(), classroomReturned.getName(), classroomReturned.getLatitude(), classroomReturned.getLongitude());
            return classroomModel;
        }
        else {

            log.info("classroom not found");
            throw new ClassroomException("classroom not found");
        }
    }

    @Override
    public ReportModel getReporting(long id) throws ReportingException {

        // Optional<Reporting> reporting = reportingRepository.findReportingById(id);
        Optional<Reporting> reporting = reportingRepository.getReportingById(id);

        if (reporting.isPresent()) {

            log.info("reporting found");
            Reporting reportingReturned = reporting.get();
            ReportModel reportModel = new ReportModel(reportingReturned.getId(), reportingReturned.getNoteProf(), reportingReturned.getSupportMaterialProf(), reportingReturned.getNoteSec(),
                    reportingReturned.getState(), reportingReturned.getIdProf(), reportingReturned.getIdSecretary(), reportingReturned.getIdClassroom());
            return reportModel;
        }
        else {

            log.info("reporting not found");
            throw new ReportingException("reporting not found");
        }
    }

    @Override
    public SecretaryRetModel getSecretary(long id) throws SecretaryException, FacultyException {

        Optional<Secretary> secretary = secretaryRepository.findSecretaryById(id);
        if (secretary.isPresent()) {

            log.info("secretary found");
            Secretary secretaryReturned = secretary.get();
            FacultyModel facultyModel = getFaculty(secretaryReturned.getId());
            SecretaryRetModel secretaryRetModel = new SecretaryRetModel(secretaryReturned.getId(), facultyModel, secretaryReturned.getVenue());
            return secretaryRetModel;
        }
        else {

            log.info("secretary not found");
            throw new SecretaryException("secretary not found");
        }
    }

    @Override
    public StudyCourseModel getStudyCourse(long id) throws StudyCourseException, FacultyException {

        Optional<StudyCourse> studyCourse = studyCourseRepository.findStudyCourseById(id);
        if (studyCourse.isPresent()) {

            log.info("study course found");
            StudyCourse studyCourseReturned = studyCourse.get();
            FacultyModel facultyModel = getFaculty(studyCourseReturned.getFaculty());
            StudyCourseModel studyCourseModel = new StudyCourseModel(studyCourseReturned.getId(), studyCourseReturned.getName(), facultyModel);
            return studyCourseModel;
        }
        else {

            log.info("study course not found");
            throw new StudyCourseException("study course not found");
        }
    }

    @Override
    public SubjectCalendarModel getSubject(long id) throws SubjectException {

        Optional<Subject> subject = subjectRepository.findSubjectById(id);
        if (subject.isPresent()) {

            log.info("subject found");
            Subject subjectReturned = subject.get();
            SubjectCalendarModel subjectCalendarModel = new SubjectCalendarModel(subjectReturned.getId(), subjectReturned.getName());
            return subjectCalendarModel;
        }
        else {

            log.info("subject not found");
            throw new SubjectException("subject not found");
        }
    }

    @Override
    public ProfessorCalendarModel getProfessorCalendar(long id) throws ProfessorException {

        Optional<Professor> professor = professorRepository.findProfessorById(id);
        if (professor.isPresent()) {

            log.info("professor found");
            Professor professorReturned = professor.get();
            ProfessorCalendarModel professorCalendarModel = new ProfessorCalendarModel(professorReturned.getId(), professorReturned.getFirstName(), professorReturned.getLastName());
            return professorCalendarModel;
        }
        else {

            log.info("professor not found");
            throw new ProfessorException("professor not found");
        }
    }

    @Override
    public ActivityTypeCalendarModel getActivityTypeCalendar(long id) throws ActivityTypeException {

        Optional<ActivityType> activityType = activityTypeRepository.findActivityTypeById(id);
        if (activityType.isPresent()) {

            log.info("activity type found");
            ActivityType activityTypeReturned = activityType.get();
            ActivityTypeCalendarModel activityTypeCalendarModel = new ActivityTypeCalendarModel(activityTypeReturned.getId(), activityTypeReturned.getName());
            return activityTypeCalendarModel;
        }
        else {

            log.info("activity type not found");
            throw new ActivityTypeException("activity type not found");
        }

    }

    @Override
    public ActivityCalendarModel getActivityCalendar(long id) throws ActivityException, ActivityTypeException {

        Optional<Activity> activity = activityRepository.findActivityById(id);
        if (activity.isPresent()) {

            log.info("activity found");
            Activity activityReturned = activity.get();
            ActivityTypeCalendarModel activityTypeCalendarModel = getActivityTypeCalendar(activityReturned.getActivityType());
            ActivityCalendarModel activityCalendarModel = new ActivityCalendarModel(activityReturned.getId(), activityTypeCalendarModel);
            return activityCalendarModel;
        }
        else {

            log.info("activity not found");
            throw new ActivityException("activity not found");
        }
    }

    @Override
    public CarryoutActivityRetModel getCarryoutActivity(long id) throws CarryoutActivityException, ActivityTypeException, ActivityException, ClassroomException,
            StudyCourseException, FacultyException, SubjectException, ProfessorException {

        Optional<CarryoutActivity> carryoutActivity = carryoutActivityRepository.findCarryoutActivityById(id);
        if (carryoutActivity.isPresent()) {

            log.info("carryout activity found");
            CarryoutActivity carryoutActivityReturned = carryoutActivity.get();
            ActivityModel activityModel = getActivity(carryoutActivityReturned.getIdActivity());
            ActivityCalendarModel activityCalendarModel = getActivityCalendar(carryoutActivityReturned.getIdActivity());
            ClassroomModel classroomModel = getClassroom(carryoutActivityReturned.getClassroomName());
            StudyCourseModel studyCourseModel = getStudyCourse(activityModel.getStudyCourse());
            SubjectCalendarModel subjectCalendarModel = getSubject(activityModel.getSubject());
            ProfessorCalendarModel professorCalendarModel = getProfessorCalendar(activityModel.getIdProf());
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd:HH:mm:SS");
            String starting = form.format(activityModel.getStart());
            String ending = form.format(activityModel.getEnd());
            CarryoutActivityRetModel carryoutActivityRetModel = new CarryoutActivityRetModel(carryoutActivityReturned.getId(), studyCourseModel, subjectCalendarModel, professorCalendarModel,
                    starting, ending, activityCalendarModel, classroomModel);
            return carryoutActivityRetModel;
        }
        else {

            log.info("carryout activity not found");
            throw new CarryoutActivityException("carryout activity not found");
        }
    }

    @Override
    public CarryoutActivityModel getCarryoutActivityModel(long id) throws CarryoutActivityException {

        Optional<CarryoutActivity> carryoutActivity = carryoutActivityRepository.findCarryoutActivityById(id);
        if (carryoutActivity.isPresent()) {

            log.info("carryout activity model found");
            CarryoutActivity carryoutActivityReturned = carryoutActivity.get();
            CarryoutActivityModel carryoutActivityModel = new CarryoutActivityModel(carryoutActivityReturned.getId(), carryoutActivityReturned.getIdActivity(),
                    carryoutActivityReturned.getClassroomName());
            return carryoutActivityModel;
        }
        else {

            log.info("carryout activity model not found");
            throw new CarryoutActivityException("carryout activity model not found");
        }
    }

    @Override
    public CarryoutActivityCalendarModel getCarryoutActivityCalendar(long id) throws CarryoutActivityException, ActivityTypeException, ActivityException, ClassroomException,
            StudyCourseException, FacultyException, SubjectException, ProfessorException {

        Optional<CarryoutActivity> carryoutActivity = carryoutActivityRepository.findCarryoutActivityById(id);
        if (carryoutActivity.isPresent()) {

            log.info("carryout activity found");
            CarryoutActivity carryoutActivityReturned = carryoutActivity.get();
            ActivityModel activityModel = getActivity(carryoutActivityReturned.getIdActivity());
            ActivityCalendarModel activityCalendarModel = getActivityCalendar(carryoutActivityReturned.getIdActivity());
            ClassroomModel classroomModel = getClassroom(carryoutActivityReturned.getClassroomName());
            StudyCourseModel studyCourseModel = getStudyCourse(activityModel.getStudyCourse());
            SubjectCalendarModel subjectCalendarModel = getSubject(activityModel.getSubject());
            ProfessorCalendarModel professorCalendarModel = getProfessorCalendar(activityModel.getIdProf());
            CarryoutActivityCalendarModel carryoutActivityCalendarModel = new CarryoutActivityCalendarModel(carryoutActivityReturned.getId(), studyCourseModel, subjectCalendarModel,
                    professorCalendarModel, activityModel.getStart(), activityModel.getEnd(), activityCalendarModel, classroomModel);
            return carryoutActivityCalendarModel;
        }
        else {

            log.info("carryout activity not found");
            throw new CarryoutActivityException("carryout activity not found");
        }
    }

    // ---------------------------------- RETURN LIST METHODS

    @Override
    public List<StudyCourse> getStudyCourses(long faculty) throws StudyCourseException {

        List<StudyCourse> studyCourses = studyCourseRepository.findAllByFaculty(faculty);
        if (!studyCourses.isEmpty()) {

            log.info("courses found");
            return studyCourses;
        }
        else {

            log.info("courses not found");
            throw new StudyCourseException("courses not found");
        }
    }

    @Override
    public List<Subject> getSubjects(int study_course) throws SubjectException {

        List<Subject> subjects = subjectRepository.findAllByStudyCourse(study_course);
        if (!subjects.isEmpty()) {

            log.info("subjects found");
            return subjects;
        }
        else {

            log.info("subjects not found");
            throw new SubjectException("subjects not found");
        }
    }

    @Override
    public List<Professor> getProfessors(int subject) throws ProfessorException {

        List<Professor> professors = professorRepository.findAllBySubject(subject);
        if (!professors.isEmpty()) {

            log.info("professors found");
            return professors;
        }
        else {

            log.info("professors not found");
            throw new ProfessorException("professors not found");
        }
    }

    @Override
    public List<Classroom> getClassrooms() throws ClassroomException {

        List<Classroom> classrooms = classroomRepository.findAll();
        if (!classrooms.isEmpty()) {

            log.info("classrooms found");
            return classrooms;
        }
        else {

            log.info("classrooms not found");
            throw new ClassroomException("classrooms not found");
        }
    }

    @Override
    public List<PersonType> getPersonTypes() throws PersonTypeException {

        List<PersonType> personTypes = personTypeRepository.findAll();
        if (!personTypes.isEmpty()) {

            log.info("types of person found");
            return personTypes;
        }
        else {

            log.info("types of person not found");
            throw new PersonTypeException("types of person not found");
        }
    }

    @Override
    public List<ActivityType> getActivityTypes() throws ActivityTypeException {

        List<ActivityType> activityTypes = activityTypeRepository.findAll();
        if (!activityTypes.isEmpty()) {

            log.info("types of activity found");
            return activityTypes;
        }
        else {

            log.info("types of activity not found");
            throw new ActivityTypeException("types of activity not found");
        }
    }

    @Override
    public List<State> getStates() throws StateException {

        List<State> states = stateRepository.findAll();
        if (!states.isEmpty()) {

            log.info("states found");
            return states;
        }
        else {

            log.info("states not found");
            throw new StateException("states not found");
        }
    }

    @Override
    public List<SupportMaterial> getSupportMaterials() throws SupportMaterialException {

        List<SupportMaterial> supportMaterials = supportMaterialRepository.findAll();
        if (!supportMaterials.isEmpty()) {

            log.info("support materials found");
            return supportMaterials;
        }
        else {

            log.info("support materials not found");
            throw new SupportMaterialException("support materials not found");
        }
    }

    /* @Override
    public List<Reporting> getReportings() throws ReportingException {

        List<Reporting> reportings = reportingRepository.findAll();
        if (!reportings.isEmpty()) {

            log.info("reportings found");
            return reportings;
        }
        else {

            log.info("reportings not found");
            throw new ReportingException("reportings not found");
        }
    } */

    @Override
    public List<ReportingRetModel> getReportingsIterator() throws ReportingException, SupportMaterialException, StateException, ProfessorException,
            ClassroomException, SecretaryException, FacultyException {

        Iterator iterator;
        List<Reporting> reportingList = new ArrayList<>();
        List<ReportingRetModel> reportingRetModels = new ArrayList<>();

        for (iterator = getIterator(); iterator.hasNext();) {
            Reporting reporting = (Reporting) iterator.next();
            reportingList.add(reporting);

            SecretaryRetModel secretaryRetModel = getSecretary(reporting.getIdSecretary());

            ReportingRetModel reportingRetModel = new ReportingRetModel(reporting.getId(), reporting.getNoteProf(), getSupportMaterial(reporting.getSupportMaterialProf()),
                    reporting.getNoteSec(), getState(reporting.getState()), getProfessor(reporting.getIdProf()), secretaryRetModel, getClassroom(reporting.getIdClassroom()));
            reportingRetModels.add(reportingRetModel);
        }

        if (!reportingList.isEmpty()) {

            log.info("reportings found");
            // return reportingList;
        }
        else {
            log.info("reportings not found");
            throw new ReportingException("reportings not found");
        }

        if (!reportingRetModels.isEmpty()) {

            log.info("reportings added");
            return reportingRetModels;
        }
        else {
            log.info("could not add reportings");
            throw new ReportingException("could not add reportings");
        }
    }

    @Override
    public List<CarryoutActivityRetModel> getCarryoutActivities() throws CarryoutActivityException, ProfessorException, ActivityTypeException, FacultyException,
            ClassroomException, SubjectException, StudyCourseException, ActivityException {

        List<CarryoutActivity> carryoutActivities = carryoutActivityRepository.findAll();
        List<CarryoutActivityRetModel> carryoutActivityRetModels = new ArrayList<>();
        if (!carryoutActivities.isEmpty()) {

            log.info("carryoutactivities found");
            for (int i = 0; i < carryoutActivities.size(); i++) {
                CarryoutActivity carryoutActivity = carryoutActivities.get(i);
                CarryoutActivityRetModel carryoutActivityRetModel = getCarryoutActivity(carryoutActivity.getId());
                carryoutActivityRetModels.add(carryoutActivityRetModel);
                log.info("carryoutactivity added");
            }
            return carryoutActivityRetModels;
        }
        else {

            log.info("carryoutactivities not found");
            throw new CarryoutActivityException("carryoutactivities not found");
        }
    }

    @Override
    public List<ActivityWithoutClassroomModel> getActivitiesWithoutClassroom() throws ActivityException, StudyCourseException,
            FacultyException, SubjectException, ProfessorException, ActivityTypeException {

        List<Activity> activities = activityRepository.findAll();
        List<CarryoutActivity> carryoutActivities = carryoutActivityRepository.findAll();
        List<ActivityWithoutClassroomModel> activityWithoutClassroomModels = new ArrayList<>();
        if (carryoutActivities.isEmpty()) {
            log.info("carryout activities not found");
            for (int k = 0; k < activities.size(); k++) {
                modelActivityWithoutClassroom(activities, activityWithoutClassroomModels, k);
            }
        }
        else if (activities.isEmpty()) {
            log.info("activities not found");
        }
        int j = 0;
        int i = 0;
        if (carryoutActivities.size() < activities.size()) {
            while (i <= j && i < carryoutActivities.size() && j < activities.size()) {
                if (activities.get(j).getId() == carryoutActivities.get(i).getIdActivity()) {
                    log.info("activity has already a classroom");
                    j++;
                    i++;
                } else {
                    log.info("found activity without classroom");
                    modelActivityWithoutClassroom(activities, activityWithoutClassroomModels, j);
                    j++;
                }
            }
            log.info("remaining activities without classroom");
            while (j < activities.size()) {
                modelActivityWithoutClassroom(activities, activityWithoutClassroomModels, j);
                j++;
            }
        }
        return activityWithoutClassroomModels;
    }

    private void modelActivityWithoutClassroom(List<Activity> activities, List<ActivityWithoutClassroomModel> activityWithoutClassroomModels, int k) throws ActivityException, StudyCourseException, FacultyException, SubjectException, ProfessorException, ActivityTypeException {
        ActivityModel activityModel = getActivity(activities.get(k).getId());
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd:HH:mm:SS");
        String starting = form.format(activityModel.getStart());
        String ending = form.format(activityModel.getEnd());
        StudyCourseModel studyCourseModel = getStudyCourse(activityModel.getStudyCourse());
        SubjectCalendarModel subjectCalendarModel = getSubject(activityModel.getSubject());
        ProfessorCalendarModel professorCalendarModel = getProfessorCalendar(activityModel.getIdProf());
        ActivityCalendarModel activityCalendarModel = getActivityCalendar(activityModel.getId());
        ActivityWithoutClassroomModel activityWithoutClassroomModel = new ActivityWithoutClassroomModel(activityModel.getId(),
                studyCourseModel, subjectCalendarModel, professorCalendarModel, starting,
                ending, activityCalendarModel);
        activityWithoutClassroomModels.add(activityWithoutClassroomModel);
    }

    @Override
    public List<CarryoutActivityCalendarModel> getCarryoutActivitiesCalendar() throws CarryoutActivityException, ProfessorException, ActivityTypeException, FacultyException,
            ClassroomException, SubjectException, StudyCourseException, ActivityException {

        List<CarryoutActivity> carryoutActivities = carryoutActivityRepository.findAll();
        List<CarryoutActivityCalendarModel> carryoutActivityCalendarModels = new ArrayList<>();
        if (!carryoutActivities.isEmpty()) {
            log.info("carryout activities for calendar found");
            for (int i = 0; i < carryoutActivities.size(); i++) {
                CarryoutActivity carryoutActivity = carryoutActivities.get(i);
                CarryoutActivityCalendarModel carryoutActivityCalendarModel = getCarryoutActivityCalendar(carryoutActivity.getId());
                carryoutActivityCalendarModels.add(carryoutActivityCalendarModel);
                log.info("carryout activity for calendar added");
            }
            return carryoutActivityCalendarModels;
        }
        else {

            log.info("carryout activities for calendar not found");
            throw new CarryoutActivityException("carryout activities for calendar not found");
        }
    }

    @Override
    public List<CarryoutActivityCalendarModel> getTodayCarryoutActivitiesCalendar() throws CarryoutActivityException, ProfessorException, ActivityTypeException, FacultyException,
            ClassroomException, SubjectException, StudyCourseException, ActivityException {

        List<CarryoutActivity> carryoutActivities = carryoutActivityRepository.findAll();
        List<CarryoutActivityCalendarModel> carryoutActivityCalendarModels = new ArrayList<>();
        if (!carryoutActivities.isEmpty()) {
            log.info("carryout activities for calendar found");
            for (int i = 0; i < carryoutActivities.size(); i++) {
                CarryoutActivity carryoutActivity = carryoutActivities.get(i);
                Date today = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String todayFormatted = format.format(today);
                CarryoutActivityCalendarModel carryoutActivityCalendarModel = getCarryoutActivityCalendar(carryoutActivity.getId());
                String activityDateFormatted = format.format(carryoutActivityCalendarModel.getStart());
                if (todayFormatted.matches(activityDateFormatted)) {
                    carryoutActivityCalendarModels.add(carryoutActivityCalendarModel);
                    log.info("today carryout activity for calendar added");
                }
                else {
                    log.info("not a today activity");
                }
            }
            return carryoutActivityCalendarModels;
        }
        else {
            log.info("carryout activities for calendar not found");
            throw new CarryoutActivityException("carryout activities for calendar not found");
        }
    }

    // DESIGN PATTERN ITERATOR PER REPORTINGS

    @Override
    public Iterator getIterator() {
        return new ReportingIterator();
    }

    private class ReportingIterator implements Iterator {

        List<Reporting> reportings = reportingRepository.findAll();
        int i;

        @Override
        public boolean hasNext() {
            if (i < reportings.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return reportings.get(i++);
            }
            return null;
        }
    }

}
