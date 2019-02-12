import {Faculty} from '../models/Faculty';

export interface StudyCourseCalendarInterface {

  id?: number;
  name: string;
  faculty: Faculty;
}
