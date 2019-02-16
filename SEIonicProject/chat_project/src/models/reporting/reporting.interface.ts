export interface ReportingInterface {

  id: number;
  noteProf: string;
  supportMaterial: {
    id: number;
    name: string;
  };
  noteSec?: string;
  state?: {
    id?: number;
    name?: string;
  };
  professor: {
    id: number;
    username: string;
    person_type: number
    firstname: string;
    lastname: string;
    biography: string;
    receptiontime: string;
    subject: number;
    dateOfBirth: Date;
  };
  secretary?: {
    id?: number;
    faculty?: {
      id?: number;
      name?: string;
    };
    venue?: string;
  };
  classroom: {
    id: number;
    name: string;
    latitude: number;
    longitude: number;
  };
}
