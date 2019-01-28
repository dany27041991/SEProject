import {EventEmitter, Injectable, OnInit, Output} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {ResponseInterface} from '../interfaces/ResponseInterface';
import {AccessToLocalStorage} from '../utils/AccessToLocalStorage';
import {Subject} from '../models/Subject';
import {Professor} from '../models/Professor';
import {AuthService} from './auth.service';
import {SupportMaterial} from '../models/SupportMaterial';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService implements OnInit {

  private APIAUTHURL = 'http://localhost:8090/user/professor/';
  private professor: Professor;
  @Output() public supportMaterial = new EventEmitter();

  constructor(private http: HttpClient, private router: Router, private cookie: CookieService, private auth: AuthService) {
  }

  ngOnInit(): void {
  }

  getSubject(): Professor {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.professor = <Professor>AccessToLocalStorage.getUser();
    this.professor.subject = null;
    this.http.get(this.APIAUTHURL + 'subject/' + AccessToLocalStorage.getUser()['person_type'], {headers}).subscribe(
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
}


