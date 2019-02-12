import {ProfessorCalendarInterface} from '../interfaces/ProfessorCalendarInterface';

export class ProfessorCalendar implements ProfessorCalendarInterface {

  id?: number;
  firstname: string;
  lastname: string;

  constructor() {}
}
