import {SubjectInterface} from '../interfaces/SubjectInterface';

export class Subject implements SubjectInterface {

  id?: number;
  name: string;
  study_course: number;
  year_course: number;

  constructor() { }
}
