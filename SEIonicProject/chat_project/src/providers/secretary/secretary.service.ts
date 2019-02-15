import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable()
export class SecretaryProvider {

  private APIAUTHURL = 'http://localhost:8090/user/secretary/';

  constructor(private http: HttpClient) {}

  getTodayCalendar() {
    let headers = new HttpHeaders(
      {
        'Content-Type' : 'application/json'
      });
    return this.http.get(this.APIAUTHURL + 'todaycarryoutactivitiescalendar', {headers})
      .pipe(map(res => res['response']));
  }

}
