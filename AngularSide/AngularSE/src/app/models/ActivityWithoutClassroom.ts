import {ActivityWithoutClassroomInterface} from '../interfaces/ActivityWithoutClassroomInterface';
import {StudyCourseCalendar} from './StudyCourseCalendar';
import {SubjectCalendar} from './SubjectCalendar';
import {ProfessorCalendar} from './ProfessorCalendar';
import {ActivityCalendar} from './ActivityCalendar';

export class ActivityWithoutClassroom implements ActivityWithoutClassroomInterface {

  id: number;
  studyCourseModel: StudyCourseCalendar;
  subjectCalendarModel: SubjectCalendar;
  professorCalendarModel: ProfessorCalendar;
  start: string;
  end: string;
  activityCalendarModel: ActivityCalendar;

  constructor() {}
}
