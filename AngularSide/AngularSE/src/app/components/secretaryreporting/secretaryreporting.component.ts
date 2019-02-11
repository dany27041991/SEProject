import { Component, OnInit } from '@angular/core';
import {Faculty} from '../../models/Faculty';
import {Secretary} from '../../models/Secretary';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {ReportingRet} from '../../models/ReportingRet';

@Component({
  selector: 'app-secretaryreporting',
  templateUrl: './secretaryreporting.component.html',
  styleUrls: ['./secretaryreporting.component.css']
})

export class SecretaryreportingComponent implements OnInit {

  public faculty: Faculty;
  public secretary: Secretary;

  public reportings: ReportingRet[];

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }
  }

  ngOnInit() {

    this.secService.getReportings();

    this.secService.reportings.subscribe((data: ReportingRet[]) => {
      this.reportings = data as Array<ReportingRet>;
    });
  }

  onSelect(reporting: ReportingRet) {
    localStorage.setItem('Reporting', JSON.stringify(reporting));
    this.route.navigate(['user/secretary/' + AccessToLocalStorage.getUser()['id'] + '/detailreportings']);
  }
}
