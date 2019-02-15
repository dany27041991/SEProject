import { Component } from '@angular/core';
import {IonicPage, NavController, NavParams, ToastController} from 'ionic-angular';
import {SecretaryProvider} from "../../providers/secretary/secretary.service";
import {DataProvider} from "../../providers/data/data.service";

/**
 * Generated class for the RatinglessonPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-ratinglesson',
  templateUrl: 'ratinglesson.html',
})
export class RatinglessonPage {

  private id: number;
  private type: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, private toast: ToastController, private faculty: DataProvider) {
    this.id = navParams.get('id');
    this.type = JSON.parse(localStorage.getItem('selectedUser'))['person_type'];
  }

  addRate(form){
    const id_student = JSON.parse(localStorage.getItem('selectedUser'))['mykey'];
    this.faculty.addRateLesson(this.id, form.value.rate, id_student).subscribe(data => {
        this.toast.create({
          message: 'Added correctly!',
          duration: 3000
        }).present();
        this.navCtrl.pop();
      },(httpResp) => {
        this.toast.create({
          message: 'A problem occurred try again now or later!',
          duration: 3000
        }).present();
      }
    );
  }

  ionViewDidLoad() {

  }

}
