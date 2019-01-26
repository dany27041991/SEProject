import { Component, OnInit } from '@angular/core';
import {Type} from '../../utils/type';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-secretary',
  templateUrl: './secretary.component.html',
  styleUrls: ['./secretary.component.css']
})
export class SecretaryComponent implements OnInit {

  constructor(private route: Router) {
    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    }
  }

  ngOnInit() {
  }

}
