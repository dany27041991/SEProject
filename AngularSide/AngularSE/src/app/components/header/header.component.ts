import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Type} from '../../utils/type';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public isLogged = false;

  constructor(private auth: AuthService, private router: Router, private cookie: CookieService) {
    this.isLogged = false;
    this.auth.isUserLogged.subscribe((bool: boolean) => {
      this.isLogged = bool;
      if (this.isLogged) {
        const personLogged = JSON.parse(localStorage.getItem('Person'));
        switch (personLogged.person_type) {
          case Type.Secretary: {
            router.navigate(['user/secretary/' + personLogged.id]);
            break;
          }
          case Type.Professor: {
            router.navigate(['user/professor/' + personLogged.id]);
            break;
          }
          case Type.Student: {
            router.navigate(['user/student/' + personLogged.id]);
            break;
          }
          default: {
            this.isLogged = false;
            router.navigate(['']);
            break;
          }
        }
      } else {
        router.navigate(['']);
      }
    });
  }

  ngOnInit() {
  }
}
