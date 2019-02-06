import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/internal/operators";

@Injectable()
export class StudentProvider {

  private APIAUTHURL = 'http://localhost:8090/user/student/';

  constructor(private http: HttpClient) {}

  addRateTeachingMaterial(id_student: number, feedback_student: number, id_material: number, note: string) {
    return this.http.post(this.APIAUTHURL + 'addrating',
      {
        id_student: id_student,
        feedback_student: feedback_student,
        id_teaching_material: id_material,
        note: note
      }, {observe: 'response'});
  }

  getLastUploadMaterial(subject: Array<number>) {
    return this.http.post(this.APIAUTHURL + 'getlastuploadmaterial',{
      subjects: subject
    }, {observe: 'response'});
  }

}
