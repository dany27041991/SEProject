import {Subject} from '../models/Subject';

export interface ProfessorInterface {
  id: number;
  username: string;
  person_type: number;
  firstname: string;
  lastname: string;
  biography?: string;
  receptiontime: string;
  subject?: Subject;
}
