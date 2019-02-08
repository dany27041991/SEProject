import {PersonInterface} from '../interfaces/PersonInterface';

export class Person implements PersonInterface {

  id?: number;
  username: string;
  password: string;
  person_type: number;

  constructor() {}
}
