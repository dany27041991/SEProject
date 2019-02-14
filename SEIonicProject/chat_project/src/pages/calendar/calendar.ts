import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Observable} from "rxjs";
import {CalendarInterface} from "../../models/calendar/calendar.interface";
import {SecretaryProvider} from "../../providers/secretary/secretary.service";

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
export class CalendarPage {

  public calendarActivities: Observable<CalendarInterface>;
  public activities: CalendarInterface[];

  constructor(public navCtrl: NavController, public navParams: NavParams, private sec: SecretaryProvider) {
    this.calendarActivities = this.sec.getTodayCalendar();
    this.calendarActivities.subscribe((data: CalendarInterface) => {
      localStorage.setItem('CalendarActivities', JSON.stringify(data));
    });
  }

  ionViewDidLoad() {
    this.activities = JSON.parse(localStorage.getItem('CalendarActivities'));
    console.log(this.activities);
  }

  openMap(latitude: number, longitude: number) {
    console.log(latitude, longitude);
    this.navCtrl.push('MapClassroomPage', {latitude, longitude});
  }
}
