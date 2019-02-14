export interface CalendarInterface {
  id: number;
  studyCourseModel: {
    id: number;
    name: string;
    faculty: {
      id: number;
      name: string;
    };
  };
  subjectCalendarModel: {
    id: number;
    name: string;
  };
  professorCalendarModel: {
    id: number;
    firstname: string;
    lastname: string;
  };
  start: Date;
  end: Date;
  activityCalendarModel: {
    id: number;
    name: {
      id: number;
      name: string;
    };
  };
  classroomModel: {
    id: number;
    name: string;
    latitude: number;
    longitude: number;
  };
}
