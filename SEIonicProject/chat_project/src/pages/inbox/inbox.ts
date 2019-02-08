import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {ChatService} from "../../providers/chat/chat.service";
import {map} from "rxjs/internal/operators";
import {StudentProvider} from "../../providers/student/student.service";
import {UploadInterface} from "../../models/upload/upload.interface";

@IonicPage()
@Component({
  selector: 'page-inbox',
  templateUrl: 'inbox.html',
})
export class InboxPage implements OnInit{

  public type_person: number;
  lastUpload : Array<UploadInterface>;

  constructor(public navCtrl: NavController, public navParams: NavParams, private chat: ChatService, private student: StudentProvider) {
    this.type_person = JSON.parse(localStorage.getItem('selectedUser'))['person_type'];
    if(this.type_person === 3) {
      chat.getUserLoggedSubject().pipe(map(data => data['response'])).subscribe((res: Array<number>) => {
        student.getLastUploadMaterial(res).subscribe(data =>
          this.lastUpload = data.body['response']
        )
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
