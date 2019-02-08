import {Component, ViewChild} from '@angular/core';
import {Content, IonicPage, NavController, NavParams} from 'ionic-angular';
import { Channel } from '../../models/channel/channel.interface';
import { ChatService } from '../../providers/chat/chat.service';
import { AngularFireList } from '@angular/fire/database';
import { ChannelMessage } from '../../models/channel/channel-message.interface';
import {SubjectInterface} from "../../models/subject/subject.interface";

@IonicPage()
@Component({
  selector: 'page-channel-chat',
  templateUrl: 'channel-chat.html',
})
export class ChannelChatPage {

  @ViewChild('scroll') content: Content;
  channel: Channel;
  channelMessages: AngularFireList<ChannelMessage[]>;

  constructor(public navCtrl: NavController, public navParams: NavParams, private chat: ChatService) {
  }

  ionViewDidLoad(){
    this.scrollBottom(1000,0);
  }

  ionViewDidEnter() {
    this.scrollBottom(1000,0);
  }

  ionViewWillLoad() {
    this.channel = this.navParams.get('channel');

    this.channelMessages = this.chat.getChannelChatRef(this.channel.mykey);
    this.scrollBottom(1000,0);
  }

  sendMessage(content: string) {
    const subj = this.setSubject(this.channel.mykey);
    let channelMessage: ChannelMessage = {
      content,
      id: JSON.parse(localStorage.getItem('selectedUser')).mykey,
      name: JSON.parse(localStorage.getItem('selectedUser')).firstName,
      lastname: JSON.parse(localStorage.getItem('selectedUser')).lastName,
      person_type: JSON.parse(localStorage.getItem('selectedUser')).person_type,
      subject: subj
    }

    this.chat.sendChannelChatMessage(this.channel.mykey, channelMessage);
    this.scrollBottom(1000,0);
  }

  setSubject(id: string): string {
    let subject = new Array<SubjectInterface>();
    subject = JSON.parse(localStorage.getItem('AllSubject'));
    var result: Array<SubjectInterface> = subject.filter(obj => {
      return obj.id === Number(this.channel.mykey);
    })
    return result[0].name;
  }

  scrollBottom(duration, timeout) {
    if(this.content._scroll) {
      setTimeout(() => {
        this.content.scrollToBottom(duration);
      }, timeout);
    }
  }
}
