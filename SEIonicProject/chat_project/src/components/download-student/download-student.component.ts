import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProfessorProvider} from "../../providers/professor/professor.service";
import {Observable} from "rxjs/Rx";
import {DownloadInterface} from "../../models/download/download.interface";
import {NavController} from "ionic-angular";
import {ModalRatePage} from "../../pages/modal-rate/modal-rate";

@Component({
  selector: 'app-download-student',
  templateUrl: 'download-student.component.html'
})
export class DownloadStudentComponent implements OnInit{

  public downloadMaterial: Observable<DownloadInterface>;

  constructor(private prof: ProfessorProvider, private navCtrl: NavController) {
    this.downloadMaterial = this.prof.downloadTeachingMaterial();
  }

  ngOnInit(): void {

  }

  addRating(i: number) {
    this.navCtrl.push('ModalRatePage', {i});
  }
}
