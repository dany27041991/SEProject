import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Cookie} from 'ng2-cookies/ng2-cookies';

@Injectable()
export class AuthService {
  private APIAUTHURL = 'http://localhost:8090/';
  @Output() public isUserLogged = new EventEmitter<boolean>();
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
        localStorage.setItem('Person', JSON.stringify(payload.body['response']));
        this.isUserLogged.emit(true);
      }, (httpResp: HttpErrorResponse) => {
        console.log(httpResp);
        this.isUserLogged.emit(false);
      }
    );
  }
  signUp() {}
  logout() {
    Cookie.delete('Jwt');
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
