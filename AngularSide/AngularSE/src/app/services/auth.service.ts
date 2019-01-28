import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {ResponseInterface} from '../interfaces/ResponseInterface';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Injectable()
export class AuthService {

  private APIAUTHURL = 'http://localhost:8090/';
  @Output() public isUserLogged = new EventEmitter<boolean>();

  constructor(private http: HttpClient, private router: Router, private cookie: CookieService) {}
  login(username: string, password: string) {
    this.http.post(this.APIAUTHURL + 'user/login',
      {
        username: username,
        password: password
      }, {observe: 'response'}
    ).subscribe(
      (payload) => {
        const token: string = payload.headers.get('Authorization');
        this.cookie.set('Jwt', token, 0.02);
        localStorage.setItem('Person', JSON.stringify(payload.body['response']));
        this.isUserLogged.emit(true);
      }, (httpResp: HttpErrorResponse) => {
        const errorBody: ResponseInterface = httpResp.error;
        this.isUserLogged.emit(false);
        if (errorBody.server !== undefined && errorBody.response !== undefined) {
          this.router.navigate(['error', {code: errorBody.server, message: errorBody.response}]);
        } else {
          this.router.navigate(['error', {code: 500, message: 'Service not available. Try after!'}]);
        }
      }
    );
  }

  logout() {localStorage.clear();
    localStorage.clear();
    this.cookie.deleteAll(null, 'localhost');
    this.isUserLogged.emit(false);
  }

  getToken() {
    return this.cookie.get('Jwt');
  }
}
