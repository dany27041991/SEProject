import {UserInterface} from '../interfaces/UserInterface';

export class User implements UserInterface {
  id_user: number;
  name: string;
  surname: string;
  email: string;
  password: string;
  type: number;
  id_course_of_study: number;

  constructor() {
    this.id_user = 0;
    this.name = '';
    this.surname = '';
    this.email = '';
    this.password = '';
    this.type = 0;
    this.id_course_of_study = 0;
  }
}
