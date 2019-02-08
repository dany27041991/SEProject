export interface DownloadInterface {
  id: number;
  subject: {
    id: number;
    name: string;
    study_course: string;
    year_course: number;
  };
  media: string;
}
