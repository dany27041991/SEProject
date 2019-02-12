import {CalendarInterface} from '../interfaces/CalendarInterface';
import {StudyCourseCalendar} from './StudyCourseCalendar';
import {SubjectCalendar} from './SubjectCalendar';
import {ProfessorCalendar} from './ProfessorCalendar';
import {ActivityCalendar} from './ActivityCalendar';
import {Classroom} from './Classroom';

export class Calendar implements CalendarInterface {

  id: number;
  studyCourseModel: StudyCourseCalendar;
  subjectCalendarModel: SubjectCalendar;
  professorCalendarModel: ProfessorCalendar;
  start: string;
  end: string;
  activityCalendarModel: ActivityCalendar;
  classroomModel: Classroom;

  constructor() {}
}
