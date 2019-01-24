import {SecretaryInterface} from '../interfaces/SecretaryInterface';

export class Secretary implements SecretaryInterface {
  id: number;
  username: string;
  person_type: number;
  faculty: number;
  venue: string;
  constructor () {}
}
