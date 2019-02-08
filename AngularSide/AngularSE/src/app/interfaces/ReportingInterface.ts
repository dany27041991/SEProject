import {SupportMaterialInterface} from './SupportMaterialInterface';
import {ProfessorReporting} from './ProfessorReporting';
import {SecretaryReportingInterface} from './SecretaryReportingInterface';
import {ClassroomInterface} from './ClassroomInterface';

export interface ReportingInterface {
  id: number;
  noteProf: string;
  supportMaterials: Array<SupportMaterialInterface>;
  noteSec: string;
  state: string;
  professors: ProfessorReporting;
  secretaries: Array<SecretaryReportingInterface>;
  classrooms: ClassroomInterface;
}
