import { Component, OnInit } from '@angular/core';
import {Faculty} from '../../models/Faculty';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {Secretary} from '../../models/Secretary';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-insertclassroom',
  templateUrl: './insertclassroom.component.html',
  styleUrls: ['./insertclassroom.component.css']
})
export class InsertclassroomComponent implements OnInit {

  public faculty: Faculty;
  public secretary: Secretary;

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }
  }

  ngOnInit() {
  }

  sending(form: NgForm) {

    if (!form.valid) {
      console.log('failed');
    } else {
      this.secService.setClassroom(form.value.name, form.value.latitude, form.value.longitude);
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }
}
