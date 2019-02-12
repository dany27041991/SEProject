import {Classroom} from '../models/Classroom';
import {StudyCourseCalendar} from '../models/StudyCourseCalendar';
import {SubjectCalendar} from '../models/SubjectCalendar';
import {ProfessorCalendar} from '../models/ProfessorCalendar';
import {ActivityCalendar} from '../models/ActivityCalendar';

export interface CalendarInterface {

  id: number;
  studyCourseModel: StudyCourseCalendar;
  subjectCalendarModel: SubjectCalendar;
  professorCalendarModel: ProfessorCalendar;
  start: string;
  end: string;
  activityCalendarModel: ActivityCalendar;
  classroomModel: Classroom;
}
