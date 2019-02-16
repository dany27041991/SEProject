import {Component, Input} from '@angular/core';
import {ReportingInterface} from "../../models/reporting/reporting.interface";

/**
 * Generated class for the LastReportingProfessorComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'last-reporting-professor',
  templateUrl: 'last-reporting-professor.html'
})
export class LastReportingProfessorComponent {

  @Input() lastReporting: ReportingInterface;

  constructor() {
  }

}
