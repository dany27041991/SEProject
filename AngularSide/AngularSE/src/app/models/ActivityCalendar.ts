import {ActivityCalendarInterface} from '../interfaces/ActivityCalendarInterface';
import {ActivityType} from './ActivityType';

export class ActivityCalendar implements ActivityCalendarInterface {

  id?: number;
  name: ActivityType;

  constructor() {}
}
