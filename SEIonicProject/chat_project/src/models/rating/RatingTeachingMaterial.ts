import {SubjectInterface} from "../subject/subject.interface";
import {Professor} from "../professor/Professor";
import {TeachingMaterial} from "../teaching-material/TeachingMaterial";

export interface RatingTeachingMaterial {
  id: number;
  feedback_student: number;
  badge_student: number;
  teachingMaterial: TeachingMaterial;
  note: string;
  subject: SubjectInterface;
  professor: Professor;
}
