import {EventEmitter, Injectable, OnInit, Output} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders, HttpRequest} from '@angular/common/http';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {ResponseInterface} from '../interfaces/ResponseInterface';
import {AccessToLocalStorage} from '../utils/AccessToLocalStorage';
import {Subject} from '../models/Subject';
import {Professor} from '../models/Professor';
import {AuthService} from './auth.service';
import {SupportMaterial} from '../models/SupportMaterial';
import {State} from '../utils/state';
import {Observable} from 'rxjs';
import {map} from 'rxjs/internal/operators';
import {ReportingInterface} from '../interfaces/ReportingInterface';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService implements OnInit {

  private APIAUTHURL = 'http://localhost:8090/user/professor/';
  private professor: Professor;
  @Output() public supportMaterial = new EventEmitter();
  @Output() public classrooms = new EventEmitter();

  constructor(private http: HttpClient, private router: Router, private cookie: CookieService, private auth: AuthService) {
  }

  ngOnInit(): void {
  }

  getSubject(): Professor {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.professor = <Professor>AccessToLocalStorage.getUser();
    this.professor.subject = null;
    this.http.get(this.APIAUTHURL + 'subject/' + AccessToLocalStorage.getUser()['subject'], {headers}).subscribe(
      (payload: ResponseInterface) => {
        this.professor.subject = <Subject>payload.response;
        localStorage.setItem('Subject', JSON.stringify(payload.response));
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
    return this.professor;
  }

  getSupportMaterial() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'materials/', {}, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('SupportMaterial', JSON.stringify(payload.response));
        this.supportMaterial.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getClassroom() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'classrooms/', {}, {headers}).subscribe(
      (payload: ResponseInterface) => {
        localStorage.setItem('Classroom', JSON.stringify(payload.response));
        this.classrooms.emit(payload.response);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  addReporting(note: string, id_material: number, id_classroom: number) {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.http.post(this.APIAUTHURL + 'addreporting',
      {
        note_prof: note,
        support_material: id_material,
        state: State.TakenIn,
        id_prof: AccessToLocalStorage.getUser()['id'],
        id_classroom: id_classroom
      }, {headers}
    ).subscribe(
      (payload: ResponseInterface) => {
        console.log('ok')
        this.router.navigate(['user/successful']);
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
  }

  getAllReportings() {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    return this.http.post(this.APIAUTHURL + 'getAllReporting', {}, {headers}).
      pipe(map((res: ResponseInterface) => res.response)) as Observable<ReportingInterface>;
  }

  pushFileToStorage(file: File, id_prof: string, subject: string): Observable<HttpEvent<{}>> {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    const formdata: FormData = new FormData();

    formdata.append('file', file);
    formdata.append('id_prof', id_prof);
    formdata.append('subject', subject);
    const req = new HttpRequest('POST', this.APIAUTHURL + 'upload', formdata, {
      reportProgress: true,
      responseType: 'text',
      headers: headers
    });

    return this.http.request(req);
  }
}


