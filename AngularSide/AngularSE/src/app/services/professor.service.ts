import {Injectable, OnInit} from '@angular/core';
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

  private APIAUTHURL = 'http://localhost:8090/user/';
  public professor: Professor;
  public supportMaterial: SupportMaterial;

  constructor(private http: HttpClient, private router: Router, private cookie: CookieService, private auth: AuthService) {
  }

  ngOnInit(): void {
  }

  getSubject(): Professor {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});
    this.professor = <Professor>AccessToLocalStorage.getUser();
    this.professor.subject = null;
    this.http.get(this.APIAUTHURL + 'professor/subject/' + AccessToLocalStorage.getUser()['person_type'], {headers}).subscribe(
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

  getSupportMaterial(): SupportMaterial {
    const headers = new HttpHeaders({'Authorization': this.auth.getToken()});

    this.http.get(this.APIAUTHURL + 'professor/support-material/' + AccessToLocalStorage.getUser()['person_type'], {headers}).subscribe(
      (payload: ResponseInterface) => {
        this.supportMaterial = <SupportMaterial>payload.response;
        localStorage.setItem('Support-Material', JSON.stringify(payload.response));
      }, (httpResp: HttpErrorResponse) => {
        if (httpResp.error['server'] !== 404 || !httpResp.error) {
          this.auth.logout();
        }
      }
    );
    return this.supportMaterial;
  }
}


