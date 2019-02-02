import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { ChatService } from '../../providers/chat/chat.service';
import { Channel } from '../../models/channel/channel.interface';
import { AngularFireList } from '@angular/fire/database';
import {Response} from "../../models/response/response.interface";

@IonicPage()
@Component({
  selector: 'page-channels',
  templateUrl: 'channels.html',
})
export class ChannelsPage {

  channelList: AngularFireList<Channel[]>;
  subject: Array<number>;

  constructor(public navCtrl: NavController, public navParams: NavParams, private alertCtrl: AlertController, private chat: ChatService) {
    chat.addAllSubjectChannel();
  }

  showAddChannelDialog() {
    this.alertCtrl.create({
      title: 'Channel Name',
      inputs: [{
        name: 'channelName'
      }],
      buttons: [
      {
        text: 'Cancel',
        role: 'cancel'
      },
      {
        text: 'Add',
        handler: data => {
          this.chat.addChannel(data.channelName);
        }
      }
      ]
    }).present();
  }

  ionViewWillLoad() {
    this.chat.getUserLoggedSubject().subscribe((data: Response) => {
      this.subject = data.response;
      localStorage.setItem('GettedSubjectForChannel', JSON.stringify(data.response));
    });
    this.getChannels();
  }

  getChannels() {
    this.subject = JSON.parse(localStorage.getItem('GettedSubjectForChannel'));
    this.channelList = <any>this.chat.getChannelListRef();
  }

  selectChannel(channel: Channel) {
    this.navCtrl.push('ChannelChatPage', { channel });
  }

}
