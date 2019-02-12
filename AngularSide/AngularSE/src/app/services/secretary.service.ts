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
import {Activity} from '../models/Activity';
import {SecretaryRet} from '../models/SecretaryRet';

@Injectable({
  providedIn: 'root'
})
export class SecretaryService implements OnInit {

  private APIAUTHURL = 'http://localhost:8090/user/secretary/';

  private secretary: Secretary;
  private secRet: SecretaryRet;

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
  @Output() public reportings = new EventEmitter();
  @Output() public states = new EventEmitter();
  @Output() public reporting = new EventEmitter();
  @Output() public calendar = new EventEmitter();
  @Output() public carryoutactivity = new EventEmitter();
  @Output() public activitiesWithoutClassroom = new EventEmitter();

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

  getReportings() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'reportings', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Reportings', JSON.stringify(payload.response));
        this.reportings.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getStates() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'states', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('States', JSON.stringify(payload.response));
        this.states.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  updateReporting(id: number, noteProf: string, supportMaterial: number, noteSec: string, state: number, professor: number, secretary: number, classroom: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'updatereporting', {
      id: id,
      noteProf: noteProf,
      supportMaterial: supportMaterial,
      noteSec: noteSec,
      state: state,
      professor: professor,
      secretary: secretary,
      classroom: classroom
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Reporting', JSON.stringify(payload.response));
        this.reporting.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getSecretary(id: number): SecretaryRet {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'secretary/' + id, {headers}).subscribe(
      (payload: ResponseInterface) => {
        this.secRet = <SecretaryRet>payload.response;
        localStorage.setItem('SecretaryReturned', JSON.stringify(payload.response));
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
    return this.secRet;
  }

  getCalendar() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'carryoutactivities', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('CarryoutActivities', JSON.stringify(payload.response));
        this.calendar.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  updateCarryoutActivity(id: number, idActivity: number, classroomName: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'updatecarryoutactivity', {
      id: id,
      idActivity: idActivity,
      classroomName: classroomName
    }, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('CarryoutActivity', JSON.stringify(payload.response));
        this.carryoutactivity.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getActivitiesWithoutClassroom() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.get(this.APIAUTHURL + 'activitieswithoutclassroom', {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('ActivitiesWithoutClassroom', JSON.stringify(payload.response));
        this.activitiesWithoutClassroom.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }
}
