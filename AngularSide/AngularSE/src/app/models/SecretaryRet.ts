import {SecretaryRetInterface} from '../interfaces/SecretaryRetInterface';
import {Faculty} from './Faculty';

export class SecretaryRet implements SecretaryRetInterface {

  id: number;
  faculty: Faculty;
  venue: string;

  constructor() {}
}
