import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable()
export class SecretaryProvider {

  private APIAUTHURL = 'http://localhost:8090/user/secretary/';

  constructor(private http: HttpClient) {}

  getTodayCalendar() {
    let headers = new HttpHeaders(
      {
        'Content-Type' : 'application/json'
      });
    return this.http.get(this.APIAUTHURL + 'todaycarryoutactivitiescalendar', {headers})
      .pipe(map(res => res['response']));
  }

  getLastClassroomChangeBySubject(subject: number) {
    return this.http.get(this.APIAUTHURL + 'notificationcarryoutactivitysubject/' + subject, {observe: 'response'});
  }

  getLastClassroomChangeByStudycourse(studycourse: number) {
    return this.http.get(this.APIAUTHURL + 'notificationcarryoutactivitystudycourse/' + studycourse, {observe: 'response'});
  }

  getLastReportingByProfessor(professor: number) {
    return this.http.get(this.APIAUTHURL + 'notificationreportingprofessor/' + professor, {observe: 'response'});
  }

  getProfessorDetails(id: number) {
    return this.http.get(this.APIAUTHURL + 'professordetails/' + id, {observe: 'response'});
  }

  getStudentDetails(id: number) {
    return this.http.get(this.APIAUTHURL + 'studentdetails/'+ id, {observe: 'response'});
  }

}
