import {Component, Input, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() checkLogin: boolean;
  constructor(private auth: AuthService, private router: Router) {

  }
  ngOnInit(): void { }

  logOut() {
      this.auth.logout();
  }
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
