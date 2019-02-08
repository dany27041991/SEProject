import {EventEmitter, Injectable, OnInit, Output} from '@angular/core';
import {Secretary} from '../models/Secretary';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {ResponseInterface} from '../interfaces/ResponseInterface';
import {Router} from '@angular/router';
import {AuthService} from './auth.service';
import {AccessToLocalStorage} from '../utils/AccessToLocalStorage';
import {Faculty} from '../models/Faculty';
import {StudyCourse} from '../models/StudyCourse';
import {Subject} from '../models/Subject';
import {Classroom} from '../models/Classroom';
import {Professor} from '../models/Professor';
import {Activity} from '../models/Activity';
import {Exam} from '../models/Exam';
import {Lesson} from '../models/Lesson';
import {Person} from '../models/Person';
import {Student} from '../models/Student';

@Injectable({
  providedIn: 'root'
})
export class SecretaryService implements OnInit {

  private APIAUTHURL = 'http://localhost:8090/user/secretary/';

  private secretary: Secretary;
  private gotActivity: Activity;
  private gotPerson: Person;

  @Output() public studyCourse = new EventEmitter();
  @Output() public subject = new EventEmitter();
  @Output() public classroom = new EventEmitter();
  @Output() public activity = new EventEmitter();
  @Output() public exam = new EventEmitter();
  @Output() public lesson = new EventEmitter();
  @Output() public person = new EventEmitter();
  @Output() public student = new EventEmitter();
  @Output() public professor = new EventEmitter();

  @Output() public courses = new EventEmitter();
  @Output() public subjects = new EventEmitter();
  @Output() public professors = new EventEmitter();
  @Output() public person_types = new EventEmitter();
  @Output() public activity_types = new EventEmitter();
  @Output() public classrooms = new EventEmitter();

  constructor(private http: HttpClient, private router: Router, private auth: AuthService) { }

  ngOnInit(): void {
  }

  // ritorna la faculty relativa alla secretary con cui ci si è autenticati

  getFaculty(): Secretary {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.secretary = <Secretary>AccessToLocalStorage.getUser();
    this.http.get(this.APIAUTHURL + 'faculty/' + AccessToLocalStorage.getUser()['faculty'], {headers}).subscribe(
      (payload: ResponseInterface) => {
        this.secretary.faculty = <Faculty>payload.response;
        localStorage.setItem('Faculty', JSON.stringify(payload.response));
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
    return this.secretary;
  }

  // aggiunge il corso di studio

  setStudyCourse(name: string, faculty: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertstudycourse', {
      name: name,
      faculty: faculty
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('StudyCourse', JSON.stringify(payload.response));
        this.studyCourse.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  // aggiunge la materia, scegliendo il corso di studio fra quelli disponibili

  getStudyCourses() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.secretary = <Secretary>AccessToLocalStorage.getUser();
    this.http.get(this.APIAUTHURL + 'courses/' + AccessToLocalStorage.getUser()['faculty'], {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('StudyCourses', JSON.stringify(payload.response));
        this.courses.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  setSubject(name: string, studyCourse: number, yearCourse: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertsubject', {
      name: name,
      studyCourse: studyCourse,
      yearCourse: yearCourse
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Subject', JSON.stringify(payload.response));
        this.subject.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  // aggiunge la classe

  setClassroom(name: string, latitude: number, longitude: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertclassroom', {
      name: name,
      latitude: latitude,
      longitude: longitude
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Classroom', JSON.stringify(payload.response));
        this.subject.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  // aggiunge esame/lezione (attività)
  // scegliendo il corso di studio, la materia, il professore, la classe e il tipo di attività fra quelli disponibili

  getActivityTypes() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'activitytypes', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('ActivityTypes', JSON.stringify(payload.response));
        this.activity_types.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  // getStudyCourses è già implementato

  getSubjects(course: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'subjects/' + course, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Subjects', JSON.stringify(payload.response));
        this.subjects.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getProfessors(subject: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'professors/' + subject, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Professors', JSON.stringify(payload.response));
        this.professors.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getClassrooms() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.secretary = <Secretary>AccessToLocalStorage.getUser();
    this.http.get(this.APIAUTHURL + 'classrooms/', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Classrooms', JSON.stringify(payload.response));
        this.classrooms.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  setActivity(studyCourse: number, subject: number, idProf: number, start: Date, end: Date, activityType: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertactivity', {
      studyCourse: studyCourse,
      subject: subject,
      idProf: idProf,
      start: start,
      end: end,
      activityType: activityType
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Activity', JSON.stringify(payload.response));
        this.activity.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getActivity(course: number, sub: number, prof: number, start: Date, end: Date, type: number): Activity {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'activity/' + course + '/' + sub + '/' + prof + '/' + start + '/' + end + '/' + type, {headers})
      .subscribe((payload: ResponseInterface) => {
        this.gotActivity = <Activity>payload.response;
        localStorage.setItem('GotActivity', JSON.stringify(payload.response));
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
    return this.gotActivity;
  }

  /* setExam(studyCourse: number, subject: number, idProf: number, start: Date, end: Date, activityType: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertexam', {
      studyCourse: studyCourse,
      subject: subject,
      idProf: idProf,
      start: start,
      end: end,
      activityType: activityType
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Exam', JSON.stringify(payload.response));
        this.exam.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  setLesson(studyCourse: number, subject: number, idProf: number, start: Date, end: Date, activityType: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertlesson', {
      studyCourse: studyCourse,
      subject: subject,
      idProf: idProf,
      start: start,
      end: end,
      activityType: activityType
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Lesson', JSON.stringify(payload.response));
        this.lesson.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  } */

  // aggiunge studente (persona)
  // scegliendo il tipo di persona e il corso di studio fra quelli disponibili

  getPersonTypes() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'persontypes', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('PersonTypes', JSON.stringify(payload.response));
        this.person_types.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  // getStudyCourses è già implementato

  // setPerson(username: string, password: string, person_type: number) {
  setPerson(username: string, password: string, personType: number, firstNamep: string, lastNamep: string, firstNames: string, lastNames: string, biography: string, receptionTime: string,
            subject: number, dateOfBirthp: Date, dateOfBirths: Date, studyCourse: number, enrollmentYear: Date) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertperson', {
      username: username,
      password: password,
      personType: personType,
      firstName: firstNamep || firstNames,
      lastName: lastNamep || lastNames,
      biography: biography,
      receptionTime: receptionTime,
      subject: subject,
      dateOfBirth: dateOfBirthp || dateOfBirths,
      studyCourse: studyCourse,
      enrollmentYear: enrollmentYear
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('SetPerson', JSON.stringify(payload.response));
        this.person.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getPerson(username: string, password: string, person_type: number): Person {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'person/' + username + '/' + password + '/' + person_type, {headers})
      .subscribe((payload: ResponseInterface) => {
        this.gotPerson = <Person>payload.response;
        console.log(this.gotPerson);
        localStorage.setItem('GotPerson', JSON.stringify(payload.response));
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      });
    return this.gotPerson;
  }

  /* setStudent(username: string, password: string, person_type: number, firstname: string, lastname: string, dateofbirth: Date, studycourse: number, enrollmentyear: Date) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertstudent', {
      username: username,
      password: password,
      personType: person_type,
      firstName: firstname,
      lastName: lastname,
      dateOfBirth: dateofbirth,
      studyCourse: studycourse,
      enrollmentYear: enrollmentyear
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Student', JSON.stringify(payload.response));
        console.log(payload.response);
        this.student.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  } */

  // aggiunge professor
  // scegliendo il tipo di persona e la materia fra quelli disponibili

  // getPersonTypes è già implementato

  // getStudyCourses è già implementato

  // getSubjects è già implementato

  // setPerson è già implementato

  /* setProfessor(username: string, password: string, person_type: number, firstname: string, lastname: string, bio: string, reception: string, subject: number, dateofbirth: Date) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertprofessor', {
      username: username,
      password: password,
      personType: person_type,
      firstName: firstname,
      lastName: lastname,
      biography: bio,
      receptionTime: reception,
      subject: subject,
      dateOfBirth: dateofbirth
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Professor', JSON.stringify(payload.response));
        console.log(payload.response);
        this.professor.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  } */
}
