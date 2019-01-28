import {ProfessorInterface} from '../interfaces/ProfessorInterface';
import {Subject} from './Subject';

export class Professor implements ProfessorInterface {
  id: number;
  username: string;
  person_type: number;
  firstname: string;
  lastname: string;
  biography?: string;
  receptiontime: string;
  subject?: Subject;
  constructor() {}
}
