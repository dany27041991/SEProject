import {Component, Input, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {Type} from '../../utils/type';
import {Cookie} from 'ng2-cookies/ng2-cookies';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() checkLogin: boolean;
  constructor(private auth: AuthService, private router: Router) {
    if (this.checkLogin) {
      const personLogged = JSON.parse(localStorage.getItem('Person'));
      switch (personLogged.person_type) {
        case Type.Secretary: {

          break;
        }
        case Type.Professor: {

          break;
        }
        case Type.Student: {

          break;
        }
        default: {
          this.checkLogin = false;
          localStorage.removeItem('Person');
          Cookie.delete('Jwt');
          break;
        }
      }
    } else {
      console.log('no jwt');
    }
  }
  ngOnInit(): void { }

  signIn(form: NgForm) {
    if (!form.valid) {
      return false;
    }
    const result = this.auth.login(form.value.username, form.value.password);
    if (result) {
      this.router.navigate(['']);
    }
  }
}
