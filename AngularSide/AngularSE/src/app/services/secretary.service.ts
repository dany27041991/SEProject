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
  @Output() public courses = new EventEmitter();
  @Output() public subject = new EventEmitter();
  @Output() public classroom = new EventEmitter();
  @Output() public activity_types = new EventEmitter();
  @Output() public subjects = new EventEmitter();
  @Output() public professors = new EventEmitter();
  @Output() public classrooms = new EventEmitter();
  @Output() public activity = new EventEmitter();
  @Output() public person_types = new EventEmitter();
  @Output() public person = new EventEmitter();

  constructor(private http: HttpClient, private router: Router, private auth: AuthService) { }

  ngOnInit(): void { }

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

  setClassroom(name: string, latitude: number, longitude: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'insertclassroom', {
      name: name,
      latitude: latitude,
      longitude: longitude
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Classroom', JSON.stringify(payload.response));
        this.classroom.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

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
}
