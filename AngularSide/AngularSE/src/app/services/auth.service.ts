import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {Cookie} from 'ng2-cookies/ng2-cookies';
import {ResponseInterface} from '../interfaces/ResponseInterface';

@Injectable()
export class AuthService {
  private isUserLogged = false;
  private APIAUTHURL = 'http://localhost:8090/';
  constructor(private http: HttpClient) {}
  isUserLoggedIn() {}
  login(username: string, password: string) {
    console.log(username);
    console.log(password)
    this.http.post(this.APIAUTHURL + 'user/login',
      {
        username: username,
        password: password
      }
    ).subscribe(
      (payload: ResponseInterface) => {
        console.log(payload.server);
        console.log(payload.response);
        /* localStorage.setItem('user_id', payload.body.response.id_user);
        localStorage.setItem('name', payload.body.response.name);
        localStorage.setItem('surname', payload.body.response.surname);
        localStorage.setItem('email', payload.body.response.email);
        localStorage.setItem('type', payload.body.response.type);
        localStorage.setItem('id_course_of_study', payload.body.response.id_course_of_study); */
        // Cookie.set('token', payload.headers.get('Authorization'), Number(payload.headers.get('Access-Control-Max-Age')));
        // this.isUserLogged = true;
      }, (httpResp: HttpErrorResponse) => {
        console.log(httpResp.error['response']);
        console.log(httpResp.error['server']);
      }
    );
  }
  signUp() {}
  logout() {}
  getUser(): Object {
    const data = JSON.parse(localStorage.getItem('person'));
    return null;
  }
  getToken() {
    return localStorage.getItem('token');
  }
}
