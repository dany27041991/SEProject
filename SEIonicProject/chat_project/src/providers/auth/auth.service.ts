import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { Account } from '../../models/account/account.interface';
import { LoginResponse } from '../../models/login/login-response.interface';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";

@Injectable()
export class AuthProvider {

  private APIAUTHURL = 'http://localhost:8090/user/';
  flag: boolean = false;

  constructor(private auth: AngularFireAuth, private http: HttpClient) {  }

  async signInWithEmailAndPassword(account: Account) {
    try {
      return <LoginResponse> {
        result: await this.auth.auth.signInWithEmailAndPassword(account.email, account.password)
      };
    }
    catch(e) {
      return <LoginResponse> {
        error: e
      };
    }
  }

  async createUserWithEmailAndPassword(account: Account) {
    try {
      return <LoginResponse> {
        result: await this.auth.auth.createUserWithEmailAndPassword(account.email, account.password)
      }
    }
    catch(e) {
      return <LoginResponse> {
        error: e
      }
    }
  }

  getAuthenticatedUser() {
    return this.auth.authState;
  }

  signOut(): Promise<void> {
    return this.auth.auth.signOut();
  }

  getAllUser(): Observable<any> {
    return this.http.post(this.APIAUTHURL + 'getAll',{});
  }
}
