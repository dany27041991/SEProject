import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {AuthService} from './services/auth.service';
import {Cookie} from 'ng2-cookies/ng2-cookies';

@Injectable()
export class RouteGuardService implements CanActivate {

  constructor(private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (Cookie.get('Jwt')) {
      return true;
    } else {
      this.router.navigate(['']);
    }
  }
}
