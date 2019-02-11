import {Component, OnInit} from '@angular/core';
import {ReportingRet} from '../../models/ReportingRet';
import {State} from '../../models/State';
import {SecretaryService} from '../../services/secretary.service';
import {Router} from '@angular/router';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {Faculty} from '../../models/Faculty';
import {Secretary} from '../../models/Secretary';
import {NgForm} from '@angular/forms';
import {SecretaryRet} from '../../models/SecretaryRet';

@Component({
  selector: 'app-detailsecretaryreporting',
  templateUrl: './detailsecretaryreporting.component.html',
  styleUrls: ['./detailsecretaryreporting.component.css']
})
export class DetailsecretaryreportingComponent implements OnInit {

  public faculty: Faculty;
  public secretary: Secretary;
  public secRep: SecretaryRet;

  public reporting: ReportingRet;
  public states: State[];

  public show: boolean;
  public sec: boolean;

  constructor(private secService: SecretaryService, private route: Router) {

    if (AccessToLocalStorage.getTypePerson() !== Type.Secretary) {
      this.route.navigate(['']);
    } else {
      this.secretary = this.secService.getFaculty();
      this.faculty = AccessToLocalStorage.getUser()['faculty'];
    }

    this.reporting = JSON.parse(localStorage.getItem('Reporting'));
  }

  ngOnInit() {

    this.secService.getStates();
    this.secService.states.subscribe((data: State[]) => {
      this.states = data as Array<State>;
    });

    if (this.reporting.secretary !== null) {
    	this.showSec();
    }
  }

  showForm() {
    this.show = true;
  }

  showSec() {
    this.sec = true;
  }

  sending(form: NgForm) {
    if (!form.valid) {
      console.log('failed');
    } else {
      this.secService.updateReporting(Number(this.reporting.id), this.reporting.noteProf, Number(this.reporting.supportMaterial.id), form.value.note, Number(form.value.state),
        Number(this.reporting.professor.id), Number(this.secretary.id), Number(this.reporting.classroom.id));
      console.log('success');
      this.route.navigate(['user/successful']);
    }
  }
}
