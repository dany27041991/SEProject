import {StudentInterface} from '../interfaces/StudentInterface';

export class Student implements StudentInterface {

  id: number;
  username?: string;
  person_type?: string;
  firstname: string;
  lastname: string;
  birthdate: Date;
  badgenumber?: string;
  studycourse: number;
  enrollmentyear: Date;

  constructor() {}
}
