import {Component, OnInit} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Observable} from "rxjs";
import {CalendarInterface} from "../../models/calendar/calendar.interface";
import {SecretaryProvider} from "../../providers/secretary/secretary.service";
import {RatinglessonPage} from "../ratinglesson/ratinglesson";

/**
 * Generated class for the CalendarPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-calendar',
  templateUrl: 'calendar.html',
})
export class CalendarPage implements OnInit{
  ngOnInit(): void {
    this.type = JSON.parse(localStorage.getItem('selectedUser'))['person_type'];
  }

  public calendarActivities: Observable<CalendarInterface[]>;
  public activities: CalendarInterface[];
  private type: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, private sec: SecretaryProvider) {
    this.calendarActivities = this.sec.getTodayCalendar();
    this.calendarActivities.subscribe((data: Array<CalendarInterface>) => {
      this.activities = data;
      localStorage.setItem('CalendarActivities', JSON.stringify(data));
    });
  }

  openMap(latitude: number, longitude: number, name: string) {
    this.navCtrl.push('MapClassroomPage', {latitude, longitude, name});
  }

  addRating(id: number) {
    this.navCtrl.push('RatinglessonPage', {id});
  }
}
