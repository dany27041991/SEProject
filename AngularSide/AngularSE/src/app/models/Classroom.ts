import {ClassroomInterface} from '../interfaces/ClassroomInterface';

export class Classroom implements ClassroomInterface {

  id?: number;
  name: string;
  latitude: number;
  longitude: number;

  constructor() {}
}
