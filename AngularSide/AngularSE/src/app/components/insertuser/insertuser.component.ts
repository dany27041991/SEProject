import { Component, OnInit } from '@angular/core';
import {Secretary} from '../../models/Secretary';
import {Faculty} from '../../models/Faculty';
import {PersonType} from '../../models/PersonType';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {NgForm} from '@angular/forms';
import {StudyCourse} from '../../models/StudyCourse';
import {Subject} from '../../models/Subject';
import {OWL_DATE_TIME_FORMATS} from 'ng-pick-datetime';
import {delay} from 'rxjs/operators';

@Component({
  selector: 'app-insertuser',
  templateUrl: './insertuser.component.html',
  styleUrls: ['./insertuser.component.css'],
  providers: [
    {provide: OWL_DATE_TIME_FORMATS, useValue: OWL_DATE_TIME_FORMATS}
  ]
})
export class InsertuserComponent implements OnInit {

  public secretary: Secretary;
  public faculty: Faculty;

  public person_types: PersonType[];
  public courses: StudyCourse[];
  public subjects: Subject[];

  public dateOfBirthprof: Date;
  public dateOfBirthstud: Date;
  public enrollment: Date;

  public birthProf: Date;
  public birthStud: Date;
  public enrollStud: Date;

  public prof: boolean;
  public stud: boolean;

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }

    this.secService.person_types.subscribe((data: PersonType[]) => {
      this.person_types = data as Array<PersonType>;
    });

    this.secService.courses.subscribe((data: StudyCourse[]) => {
      this.courses = data as Array<StudyCourse>;
    });

    this.secService.subjects.subscribe((data: Subject[]) => {
      this.subjects = data as Array<Subject>;
    });

    this.prof = false;
    this.stud = false;
  }

  ngOnInit() {

    this.secService.getPersonTypes();
    this.secService.getStudyCourses();
  }

  checkCourse(c: number) {
    this.secService.getSubjects(c);
  }

  onSelect(t: number) {
    switch (Number(t)) {
      case Type.Professor: {
        this.prof = true;
        this.stud = false;
        break;
      }
      case Type.Student: {
        this.stud = true;
        this.prof = false;
        break;
      }
      default: {
        this.prof = false;
        this.stud = false;
        console.log('not a valid user type');
        break;
      }
    }
  }

  getBirthProf(d: Date) {
    this.birthProf = d;
  }

  getBirthStud(d: Date) {
    this.birthStud = d;
  }

  getEnrollStud(d: Date) {
    this.enrollStud = d;
  }

  sending(form: NgForm) {
    if (!form.valid) {
      console.log('failed');
    } else {
      this.secService.setPerson(form.value.username, form.value.password, Number(form.value.type), form.value.firstnameprof, form.value.lastnameprof, form.value.firstnamestud,
        form.value.lastnamestud, form.value.bio, form.value.rectime, Number(form.value.subject), this.birthProf, this.birthStud, Number(form.value.coursestud), this.enrollStud);
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }

}
