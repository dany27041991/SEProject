import {StudentInterface} from '../interfaces/StudentInterface';

export class Student implements StudentInterface {
  id: number;
  username: string;
  person_type: string;
  firstname: string;
  lastname: string;
  birthdate: string;
  badgenumber: string;
  studycourse: string;
  enrollmentyear: string;
  constructor() {}
}
