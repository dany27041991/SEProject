import { Component, OnInit } from '@angular/core';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {Faculty} from '../../models/Faculty';
import {StudyCourse} from '../../models/StudyCourse';
import {Secretary} from '../../models/Secretary';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-insertsubject',
  templateUrl: './insertsubject.component.html',
  styleUrls: ['./insertsubject.component.css']
})
export class InsertsubjectComponent implements OnInit {

  public faculty: Faculty;
  public secretary: Secretary;

  public studyCourses: StudyCourse[];

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }

    this.secService.courses.subscribe((data: StudyCourse[]) => {
      console.log(data);
      this.studyCourses = data as Array<StudyCourse>;
    });
  }

  ngOnInit() {

    this.secService.getStudyCourses();
  }

  sending(form: NgForm) {

    if (!form.valid) {
      console.log('failed');
    } else {
      this.secService.setSubject(form.value.name, Number(form.value.course), Number(form.value.year));
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }

}
