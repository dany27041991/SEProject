import { Component, OnInit } from '@angular/core';
import {Faculty} from '../../models/Faculty';
import {Secretary} from '../../models/Secretary';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {Calendar} from '../../models/Calendar';
import {Classroom} from '../../models/Classroom';
import {ActivityWithoutClassroom} from '../../models/ActivityWithoutClassroom';

@Component({
  selector: 'app-didacticcalendar',
  templateUrl: './didacticcalendar.component.html',
  styleUrls: ['./didacticcalendar.component.css']
})
export class DidacticcalendarComponent implements OnInit {

  public faculty: Faculty;
  public secretary: Secretary;

  public calendar: Calendar[];
  public classrooms: Classroom[];
  public activitiesWithoutClassroom: ActivityWithoutClassroom[];
  public show: boolean;
  public class: boolean;

  public idNew: number;
  public idAct: number;

  public idNewCarry: number;
  public idActCarry: number;

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }
  }

  ngOnInit() {
    this.secService.getClassrooms();
    this.secService.getCalendar();
    this.secService.getActivitiesWithoutClassroom();

    this.secService.classrooms.subscribe((data: Classroom[]) => {
      this.classrooms = data as Array<Classroom>;
    });
    this.secService.calendar.subscribe((data: Calendar[]) => {
      this.calendar = data as Array<Calendar>;
    });
    this.secService.activitiesWithoutClassroom.subscribe((data: ActivityWithoutClassroom[]) => {
      this.activitiesWithoutClassroom = data as Array<ActivityWithoutClassroom>;
    });
  }

  onSelect(id: number, act: number) {
    this.show = true;
    this.idNew = id;
    this.idAct = act;
  }

  sending(cla: number) {
    if (Number(cla) === 0) {
      console.log('failed');
    } else {
      this.secService.updateCarryoutActivity(this.idNew, this.idAct, Number(cla));
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }

  onClick(id: number, act: number) {
    this.class = true;
    this.idNewCarry = id;
    this.idActCarry = act;
  }

  setting(cla: number) {
    if (Number(cla) === 0) {
      console.log('failed');
    } else {
      this.secService.setCarryoutActivity(this.idNewCarry, this.idActCarry, Number(cla));
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }
}
