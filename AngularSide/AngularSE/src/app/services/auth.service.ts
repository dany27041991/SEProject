import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AuthService {
  private isUserLogged = false;
  private APIAUTHURL = 'http://localhost:8090/';
  constructor(private http: HttpClient) {}
  isUserLoggedIn() {}
  login() {}
  signUp() {}
  logout() {}
  getUser() {}
  getToken() {}
}
