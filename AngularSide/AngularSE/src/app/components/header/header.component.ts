import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {Type} from '../../utils/type';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public isLogged: boolean;
  constructor(private auth: AuthService) {
    this.auth.isUserLogged.subscribe((bool: boolean) => {
      console.log(true);
      this.isLogged = bool;
    });
  }

  ngOnInit() {
  }

}
