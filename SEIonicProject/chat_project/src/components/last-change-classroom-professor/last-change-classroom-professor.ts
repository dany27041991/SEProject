import {Component, Input} from '@angular/core';
import {CalendarInterface} from "../../models/calendar/calendar.interface";

/**
 * Generated class for the LastChangeClassroomProfessorComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'last-change-classroom-professor',
  templateUrl: 'last-change-classroom-professor.html'
})
export class LastChangeClassroomProfessorComponent {

  @Input() lastCalendarProf: CalendarInterface;

  constructor() {
  }

}
