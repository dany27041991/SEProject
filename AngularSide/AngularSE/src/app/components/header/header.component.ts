import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Type} from '../../utils/type';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isLogged = false;
  public typeLogged = {logged: false, type: 0};

  constructor(private auth: AuthService, private router: Router) {
    this.auth.isUserLogged.subscribe((bool: boolean) => {
      this.isLogged = bool;
      this.typeLogged.logged = bool;
      if (this.isLogged) {
        const personLogged = JSON.parse(localStorage.getItem('Person'));
        switch (personLogged.person_type) {
          case Type.Secretary: {
            this.typeLogged.type = Type.Secretary;
            router.navigate(['user/secretary/' + personLogged.id]);
            break;
          }
          case Type.Professor: {
            this.typeLogged.type = Type.Professor;
            router.navigate(['user/professor/' + personLogged.id]);
            break;
          }/*
          case Type.Student: {
            router.navigate(['user/student/' + personLogged.id]);
            break;
          }*/
          default: {
            this.isLogged = false;
            this.typeLogged.logged = false;
            this.typeLogged.type = 0;
            router.navigate(['']);
            break;
          }
        }
      } else {
        this.typeLogged.logged = false;
        this.typeLogged.type = 0;
        router.navigate(['']);
      }
    });
  }

  ngOnInit() {
  }
}
