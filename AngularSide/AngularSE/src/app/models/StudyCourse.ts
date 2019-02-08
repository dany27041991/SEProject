import {StudyCourseInterface} from '../interfaces/StudyCourseInterface';

export class StudyCourse implements StudyCourseInterface {

  id?: number;
  name: string;
  faculty: number;

  constructor() {}
}
