import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController} from 'ionic-angular';
import {StudentProvider} from "../../providers/student/student.service";

/**
 * Generated class for the ModalRatePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-modal-rate',
  templateUrl: 'modal-rate.html',
})
export class ModalRatePage {

  private id: number;

  constructor(private navCtrl: NavController, private navParams: NavParams, private student: StudentProvider, private toast: ToastController) {
    this.id = this.navParams.get('i');
  }

  ionViewDidLoad() {}

  addRate(form){
    const id_student = JSON.parse(localStorage.getItem('selectedUser'))['mykey'];
    this.student.addRateTeachingMaterial(id_student, form.value.rate, this.id, form.value.note).subscribe(data => {
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

}
