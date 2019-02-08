import {SubjectInterface} from "../subject/subject.interface";

export interface UploadInterface {
  id: number;
  subject: SubjectInterface;
  media: string;
}
