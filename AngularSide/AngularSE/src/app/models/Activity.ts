import {ActivityInterface} from '../interfaces/ActivityInterface';

export class Activity implements ActivityInterface {

  id?: number;
  study_course: number;
  subject: number;
  id_prof: number;
  start: Date;
  end: Date;
  activity_type: number;

  constructor() {}

}
