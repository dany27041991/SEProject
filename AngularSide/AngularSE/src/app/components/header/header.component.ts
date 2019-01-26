import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public isLogged: boolean;
  constructor(private auth: AuthService) {
    this.auth.isUserLogged.subscribe((bool: boolean) => {
      this.isLogged = bool;
    });
  }

  ngOnInit() {
  }
}
