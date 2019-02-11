import {SupportMaterial} from '../models/SupportMaterial';
import {State} from '../models/State';
import {Professor} from '../models/Professor';
import {Classroom} from '../models/Classroom';
import {SecretaryRet} from '../models/SecretaryRet';

export interface ReportingRetInterface {

  id: number;
  noteProf: string;
  supportMaterial: SupportMaterial;
  noteSec?: string;
  state: State;
  professor: Professor;
  secretary?: SecretaryRet;
  classroom: Classroom;
}
