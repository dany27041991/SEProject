import {Faculty} from '../models/Faculty';

export interface SecretaryInterface {
  id: number;
  username: string;
  person_type: number;
  faculty: Faculty;
  venue: string;
}
