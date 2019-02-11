import {ReportingSecInterface} from '../interfaces/ReportingSecInterface';

export class Reporting implements ReportingSecInterface {

  id: number;
  noteProf: string;
  supportMaterialProf: number;
  noteSec?: string;
  state: number;
  idProf: number;
  idSecretary?: number;
  idClassroom: number;

  constructor() {}
}
