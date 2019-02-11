import {ReportingRetInterface} from '../interfaces/ReportingRetInterface';
import {SupportMaterial} from './SupportMaterial';
import {State} from './State';
import {Professor} from './Professor';
import {Classroom} from './Classroom';
import {SecretaryRet} from './SecretaryRet';

export class ReportingRet implements ReportingRetInterface {

  id: number;
  noteProf: string;
  supportMaterial: SupportMaterial;
  noteSec?: string;
  state: State;
  professor: Professor;
  secretary?: SecretaryRet;
  classroom: Classroom;

  constructor() {}
}
