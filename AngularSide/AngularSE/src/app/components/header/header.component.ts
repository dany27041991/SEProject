import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Type} from '../../utils/type';
import {Cookie} from 'ng2-cookies/ng2-cookies';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public isLogged = false;
  constructor(private auth: AuthService, private router: Router) {
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
            localStorage.clear();
            Cookie.deleteAll();
            router.navigate(['']);
            break;
          }
        }
      } else {
        router.navigate(['']);
      }
    });
    if (!AccessToLocalStorage.getJwt()) {
      this.isLogged = false;
    } else {
      this.isLogged = true;
    }
  }

  ngOnInit() {
  }
}
