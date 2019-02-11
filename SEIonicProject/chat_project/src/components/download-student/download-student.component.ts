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
  public downloadMaterialCopy: Array<DownloadInterface>;
  flag = false;

  constructor(private prof: ProfessorProvider, private navCtrl: NavController) {
    this.downloadMaterial = this.prof.downloadTeachingMaterial();
    this.downloadMaterial.subscribe((data: DownloadInterface) => {
      localStorage.setItem('AllDownload', JSON.stringify(data));
    });
  }

  ngOnInit(): void {

  }

  addRating(i: number) {
    this.navCtrl.push('ModalRatePage', {i});
  }

  private onSearch(value: string) {
    this.downloadMaterialCopy = JSON.parse(localStorage.getItem('AllDownload'));
    if (value) {
      this.flag = true;
      this.downloadMaterialCopy = this.downloadMaterialCopy.filter(function (key) {
        if (value.toUpperCase() === key.subject.name.toUpperCase() || value.toUpperCase() === key.media.toUpperCase()) {
          return key;
        } else {
          if (key.subject.name.toUpperCase().search(value.toUpperCase()) !== -1
            || key.media.toUpperCase().search(value.toUpperCase()) !== -1) {
            return key;
          }
        }
      });
    } else {
      this.flag = false;
    }
  }
}
