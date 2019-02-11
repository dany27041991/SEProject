import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {ChatService} from "../../providers/chat/chat.service";
import {map} from "rxjs/internal/operators";
import {StudentProvider} from "../../providers/student/student.service";
import {UploadInterface} from "../../models/upload/upload.interface";
import {ProfessorProvider} from "../../providers/professor/professor.service";
import {RatingTeachingMaterial} from "../../models/rating/RatingTeachingMaterial";

@IonicPage()
@Component({
  selector: 'page-inbox',
  templateUrl: 'inbox.html',
})
export class InboxPage implements OnInit{

  public type_person: number;
  lastUpload : Array<UploadInterface>;
  lastRateRes: RatingTeachingMaterial;

  constructor(public navCtrl: NavController, public navParams: NavParams, private chat: ChatService, private student: StudentProvider, private prof: ProfessorProvider) {
    this.type_person = JSON.parse(localStorage.getItem('selectedUser'))['person_type'];
    if(this.type_person === 3) {
      chat.getUserLoggedSubject().pipe(map(data => data['response'])).subscribe((res: Array<number>) => {
        student.getLastUploadMaterial(res).subscribe(data =>
          this.lastUpload = data.body['response']
        )
      });
    }
    if(this.type_person === 2) {
      prof.rateDownloadMaterial().pipe(map(data => data.body['response'])).subscribe((res: Array<RatingTeachingMaterial>) => {
        if(res.length) {
          let lastRate: Array<RatingTeachingMaterial> = res;
          lastRate = lastRate.filter(function (res) {
            return (res.professor.firstName === JSON.parse(localStorage.getItem('selectedUser'))['firstName'] &&
              res.professor.lastName === JSON.parse(localStorage.getItem('selectedUser'))['lastName']);
          });
          lastRate.reverse();
          this.lastRateRes = lastRate[0];
        }
      });
    }
  }

  ionViewDidLoad() {
  }

  ngOnInit(): void {
    this.chat.getLastChannelMessages();
  }

  navigateToSearchUserPage() {
    this.navCtrl.push('SearchUserPage');
  }

}
