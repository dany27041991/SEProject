import {Faculty} from './Faculty';
import {StudyCourseCalendarInterface} from '../interfaces/StudyCourseCalendarInterface';

export class StudyCourseCalendar implements StudyCourseCalendarInterface {

  id?: number;
  name: string;
  faculty: Faculty;

  constructor() {}
}
