import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Cookie} from 'ng2-cookies/ng2-cookies';
import { Type} from '../utils/type';
import {ResponseInterface} from '../interfaces/ResponseInterface';

@Injectable()
export class AuthService {
  private isUserLogged = false;
  private APIAUTHURL = 'http://localhost:8090/';
  private typeOfUser: number;
  constructor(private http: HttpClient) {}

  isUserLoggedIn() {}
  login(username: string, password: string) {
    this.http.post(this.APIAUTHURL + 'user/login',
      {
        username: username,
        password: password
      }, {observe: 'response'}
    ).subscribe(
      (payload) => {
        const token: string = payload.headers.get('Authorization');
        Cookie.set('Jwt', token);
        const personBody =  <ResponseInterface>payload.body;
        const personType: number = personBody.response['person_type'];
        this.typeOfUser = personType;
        switch (personType) {
          case Type.Secretary: {
            // console.log('Secretary')
            localStorage.setItem('Secretary', JSON.stringify(payload.body['response']));
            this.isUserLogged = true;
            break;
          }
          case Type.Professor: {
            // console.log('Professor')
            localStorage.setItem('Professor', JSON.stringify(payload.body['response']));
            this.isUserLogged = true;
            break;
          }
          case Type.Student: {
            // console.log('Student')
            localStorage.setItem('Student', JSON.stringify(payload.body['response']));
            this.isUserLogged = true;
            break;
          }
          default: {
            // console.log('Default')
            break;
          }
        }
      }, (httpResp: HttpErrorResponse) => {
        const errorCode: number = httpResp.error['server'];
        switch (errorCode) {
          case 401: {
            console.log('Unauthorized');
            console.log(httpResp.error['response']);
            break;
          }
          case 404: {
            console.log('Not Found');
            console.log(httpResp.error['response']);
            break;
          }
          case 403: {
            console.log('Forbidden');
            console.log(httpResp.error['response']);
            break;
          }
          default: {
            console.log('Default')
            console.log(httpResp.error['response']);
            break;
          }
        }
      }
    );
  }
  signUp() {}
  logout() {
    Cookie.delete('Jwt');
    switch (this.typeOfUser) {
      case Type.Secretary: {
        localStorage.removeItem('Secretary');
        this.isUserLogged = false;
        break;
      }
      case Type.Professor: {
        localStorage.removeItem('Professor');
        this.isUserLogged = false;
        break;
      }
      case Type.Student: {
        localStorage.removeItem('Student');
        this.isUserLogged = false;
        break;
      }
      default: {
        // console.log('Default')
        break;
      }
    }
    return true;
  }
  getUser(): Object {
    const data = JSON.parse(localStorage.getItem('person'));
    return null;
  }
  getToken() {
    return localStorage.getItem('token');
  }
}
