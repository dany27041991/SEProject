import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/internal/operators";

@Injectable()
export class ProfessorProvider {

  private APIAUTHURL = 'http://localhost:8090/user/professor/';

  constructor(private http: HttpClient) {}

  downloadTeachingMaterial() {
    const idUser = JSON.parse(localStorage.getItem('selectedUser'))['mykey'];
    let headers = new HttpHeaders(
    {
      'Content-Type' : 'application/json'
    });
    return this.http.get(this.APIAUTHURL + 'getAllTeachingMaterials/'+idUser, {headers})
      .pipe(map(res => res['response']));
  }

  rateDownloadMaterial() {
    return this.http.post(this.APIAUTHURL + 'getRateDownload',{}, {observe: 'response'});
  }
}
