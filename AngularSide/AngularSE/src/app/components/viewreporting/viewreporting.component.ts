import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {ProfessorService} from '../../services/professor.service';
import {ReportingInterface} from '../../interfaces/ReportingInterface';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-viewreporting',
  templateUrl: './viewreporting.component.html',
  styleUrls: ['./viewreporting.component.css']
})
export class ViewreportingComponent implements OnInit {

  public lastname: string;
  public reporting: Observable<ReportingInterface>;
  public reportingFilterd: Array<ReportingInterface>;
  flag = false;

  constructor(private prof: ProfessorService) { }

  private onSearch(value: string) {
    this.reportingFilterd = JSON.parse(localStorage.getItem('AllReporting'));
    if (value) {
      this.flag = true;
      this.reportingFilterd = this.reportingFilterd.filter(function (key) {
        if (value.toUpperCase() === key.professors.lastName.toUpperCase() || value.toUpperCase() === key.professors.firstName.toUpperCase()
          || value.toUpperCase() === key.classrooms.name.toUpperCase()) {
          return key;
        } else {
          if (key.professors.lastName.toUpperCase().search(value.toUpperCase()) !== -1
            || key.professors.firstName.toUpperCase().search(value.toUpperCase()) !== -1
            || key.classrooms.name.toUpperCase().search(value.toUpperCase()) !== -1) {
            return key;
          }
        }
      });
    } else {
      this.flag = false;
    }
  }

  ngOnInit() {
    this.lastname = AccessToLocalStorage.getUser()['lastname'];
    this.reporting = this.prof.getAllReportings();
    this.prof.getAllReportings().subscribe((data: ReportingInterface) => {
      localStorage.setItem('AllReporting', JSON.stringify(data));
    });
    this.reportingFilterd = JSON.parse(localStorage.getItem('AllReporting'));
  }

}
