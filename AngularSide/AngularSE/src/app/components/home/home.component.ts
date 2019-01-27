import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private auth: AuthService, private cookie: CookieService) {
    this.auth.logout();
    localStorage.clear();
    this.cookie.deleteAll(null, 'localhost');
  }

  ngOnInit() {
  }

}
