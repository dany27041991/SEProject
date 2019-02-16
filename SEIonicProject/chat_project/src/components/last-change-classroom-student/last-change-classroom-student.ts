import {Component, Input} from '@angular/core';
import {CalendarInterface} from "../../models/calendar/calendar.interface";

/**
 * Generated class for the LastChangeClassroomStudentComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'last-change-classroom-student',
  templateUrl: 'last-change-classroom-student.html'
})
export class LastChangeClassroomStudentComponent {

  @Input() lastCalendarStud: CalendarInterface;

  constructor() {
  }

}
