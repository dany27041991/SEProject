import { Component, OnInit } from '@angular/core';
import {Type} from '../../utils/type';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Router} from '@angular/router';
import {Secretary} from '../../models/Secretary';
import {SecretaryService} from '../../services/secretary.service';

@Component({
  selector: 'app-secretary',
  templateUrl: './secretary.component.html',
  styleUrls: ['./secretary.component.css']
})
export class SecretaryComponent implements OnInit {

  public secretary: Secretary;

  constructor(private route: Router, private secService: SecretaryService) {
    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
    }
  }

  ngOnInit() {
  }

}
