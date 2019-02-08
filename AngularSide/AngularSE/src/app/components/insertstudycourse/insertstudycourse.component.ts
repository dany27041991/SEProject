import {Component, OnInit} from '@angular/core';
import {Faculty} from '../../models/Faculty';
import {SecretaryService} from '../../services/secretary.service';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Secretary} from '../../models/Secretary';
import {Router} from '@angular/router';
import {Type} from '../../utils/type';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-insertstudycourse',
  templateUrl: './insertstudycourse.component.html',
  styleUrls: ['./insertstudycourse.component.css']
})
export class InsertstudycourseComponent implements OnInit {

  public facultyRet: Faculty;
  public secretary: Secretary;

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.facultyRet = AccessToLocalStorage.getUser()['faculty'];
    }
  }

  ngOnInit() { }

  sending(form: NgForm) {
    if (!form.valid) {
      console.log('failed');
    } else {
      this.secService.setStudyCourse(form.value.name, Number(this.secretary.faculty.id));
      console.log('success');
    }
  }
}
