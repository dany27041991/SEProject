import {SecretaryInterface} from '../interfaces/SecretaryInterface';
import {Faculty} from './Faculty';

export class Secretary implements SecretaryInterface {
  id: number;
  username: string;
  person_type: number;
  faculty: Faculty;
  venue: string;

  constructor () {}
}
