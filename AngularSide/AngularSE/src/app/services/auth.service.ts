import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {User} from '../classes/User';
import {Cookie} from 'ng2-cookies/ng2-cookies';

@Injectable()
export class AuthService {
  private isUserLogged = false;
  private APIAUTHURL = 'http://localhost:8090/';
  constructor(private http: HttpClient) {}
  isUserLoggedIn() {}
  login(email: string, password: string) {
    this.http.post(this.APIAUTHURL + 'login',
      {
        email: email,
        password: password
      }, {observe: 'response'}
    ).subscribe(
      (payload: HttpResponse<any>) => {
        localStorage.setItem('user_id', payload.body.response.id_user);
        localStorage.setItem('name', payload.body.response.name);
        localStorage.setItem('surname', payload.body.response.surname);
        localStorage.setItem('email', payload.body.response.email);
        localStorage.setItem('type', payload.body.response.type);
        localStorage.setItem('id_course_of_study', payload.body.response.id_course_of_study);
        Cookie.set('token', payload.headers.get('Authorization'), Number(payload.headers.get('Access-Control-Max-Age')));
        this.isUserLogged = true;
      }
    );
  }
  signUp() {}
  logout() {}
  getUser(): User {
    const data = JSON.parse(localStorage.getItem('user'));
    const user = new User();
    if (data) {
      user.name = data['username'];
      user.email = data['email'];
    }
    return user;
  }
  getToken() {
    return localStorage.getItem('token');
  }
}
