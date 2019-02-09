import { Component, OnInit } from '@angular/core';
import {Secretary} from '../../models/Secretary';
import {Faculty} from '../../models/Faculty';
import {ActivityType} from '../../models/ActivityType';
import {StudyCourse} from '../../models/StudyCourse';
import {Subject} from '../../models/Subject';
import {Professor} from '../../models/Professor';
import {Classroom} from '../../models/Classroom';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-insertactivity',
  templateUrl: './insertactivity.component.html',
  styleUrls: ['./insertactivity.component.css']
})
export class InsertactivityComponent implements OnInit {

  public secretary: Secretary;
  public faculty: Faculty;

  public activity_types: ActivityType[];
  public study_courses: StudyCourse[];
  public subjects: Subject[];
  public professors: Professor[];
  public classrooms: Classroom[];

  public startingTime: Date;
  public endingTime: Date;

  public start: Date;
  public end: Date;

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }

    this.secService.activity_types.subscribe((data: ActivityType[]) => {
      this.activity_types = data as Array<ActivityType>;
    });

    this.secService.courses.subscribe((data: StudyCourse[]) => {
      this.study_courses = data as Array<StudyCourse>;
    });

    this.secService.subjects.subscribe((data: Subject[]) => {
      this.subjects = data as Array<Subject>;
    });

    this.secService.professors.subscribe((data: Professor[]) => {
      this.professors = data as Array<Professor>;
    });

    this.secService.classroom.subscribe((data: Classroom[]) => {
      this.classrooms = data as Array<Classroom>;
    });
  }

  ngOnInit() {

    this.secService.getActivityTypes();
    this.secService.getStudyCourses();
    this.secService.getClassrooms();
  }

  checkCourse(course: number) {
    this.secService.getSubjects(course);
  }

  checkSubject(sub: number) {
    this.secService.getProfessors(sub);
  }

  getStart(d: Date) {
    this.start = d;
  }

  getEnd(d: Date) {
    this.end = d;
  }

  sending(form: NgForm) {
    if (!form.valid) {
      console.log('failed');
    } else {
      this.secService.setActivity(Number(form.value.course), Number(form.value.subject), Number(form.value.prof), this.start, this.end, Number(form.value.type));
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }
}
