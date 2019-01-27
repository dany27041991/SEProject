import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Injectable()
export class RouteGuardService implements CanActivate {

  constructor(private router: Router, private cookie: CookieService) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.cookie.get('Jwt')) {
      return true;
    } else {
      this.router.navigate(['']);
    }
  }
}
