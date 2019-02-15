import {SubjectInterface} from "../subject/subject.interface";

export interface RatelessonInterface {
  id: number;
  rate: number;
  activity: {
    id: number;
    studyCourse: number;
    subject: number;
    idProf: number;
    start: any;
    end: any
    activityType: number;
  },
  badge_student: number;
  subject: SubjectInterface;
  studyCourse: {
    id: number;
    name: string;
    faculty: number;
  }
}
