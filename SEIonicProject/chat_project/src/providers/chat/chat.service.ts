import { Injectable, Output, EventEmitter } from "@angular/core";
import { AngularFireDatabase, AngularFireList } from "@angular/fire/database";
import { Channel } from "../../models/channel/channel.interface";
import { ChannelMessage } from "../../models/channel/channel-message.interface";
import { Message } from "../../models/messages/message.interface";
import { UUID } from 'angular2-uuid';
import { Observable} from "rxjs/Rx";
import { Profile } from "../../models/profile/profile.interface";
import {HttpClient} from "@angular/common/http";
import {Response} from "../../models/response/response.interface";
import {map} from "rxjs/internal/operators";
import {SubjectInterface} from "../../models/subject/subject.interface";

@Injectable()
export class ChatService {

    keys: Observable<{}[]>;
    private userProfile: Profile;
    messages: Message[] = [];
    lastMessages: Message[] = [];
    private APIAUTHURL = 'http://localhost:8090/user/faculty/';

    @Output() chat = new EventEmitter<Message[]>();
    @Output() last = new EventEmitter<Message[]>();
    @Output() lastChannelMessages = new EventEmitter<Array<ChannelMessage>>();

    constructor(private database: AngularFireDatabase, private http: HttpClient) {

    }

    addAllSubjectChannel() {
      this.database.list(`channel-names`).valueChanges().subscribe((channelExisting: Array<SubjectInterface>) => {
        localStorage.setItem('ExistingChannel', JSON.stringify(channelExisting));
      });
      setTimeout(() => {
        this.http.post(this.APIAUTHURL + 'getAllSubject',{}).subscribe((data: Response) => {
          const courseList: Array<SubjectInterface> = data.response;
          localStorage.setItem('AllSubject', JSON.stringify(courseList));
          const channelExisting: Array<SubjectInterface> = JSON.parse(localStorage.getItem('ExistingChannel'));
          for(let i = 0; i<courseList.length ;i++) {
            const el1 = courseList[i];
            for(let k = 0; k<channelExisting.length ;k++) {
              const el2 = channelExisting[k];
              if(el1.id===el2['mykey']) {
                courseList.splice(i,1);
                i--;
                break;
              }
            }
          }
          if(courseList.length>0) {
            Object.keys(courseList).forEach(k => {
              this.database.list(`channel-names`).push({ name: courseList[k].name, mykey: courseList[k].id,
                studyCourse: courseList[k].studyCourse, yearCourse: courseList[k].yearCourse });
            });
          }
        });
      }, 3000);
    }

    addChannel(channelName: string) {
        this.database.list(`channel-names`).push({ name: channelName, mykey: UUID.UUID(), faculty: '0' });
    }

    getChannelListRef(): AngularFireList<Channel> {
        return <any>this.database.list(`channel-names`).valueChanges();
    }

    getChannelChatRef(channelKey: string): AngularFireList<ChannelMessage[]> {
        return <any>this.database.list(`channels/${channelKey}`).valueChanges();
    }

    getLastChannelMessages() {
      const user = JSON.parse(localStorage.getItem('selectedUser'));
      let lastMessagesChannel = new Array<ChannelMessage>();
      this.getUserLoggedSubject().pipe(map(res => res['response'])).subscribe(data => {
        for (let subject of data) {
          <any>this.database.list(`channels/${subject}`).valueChanges().subscribe((dataMex: Array<ChannelMessage>) => {
            for (var _i = (dataMex.length-1); _i >= 0; _i--) {
              if(dataMex[_i].id!=user['mykey']) {
                lastMessagesChannel.push(dataMex[_i]);
                break;
              }
            }
          })
        }
        this.lastChannelMessages.emit(lastMessagesChannel);
      });
    }

    async sendChannelChatMessage(channelKey: string, message: ChannelMessage) {
        await this.database.list(`channels/${channelKey}`).push(message);
        this.getLastChannelMessages();
    }

    async sendChat(message: Message) {
        await this.database.list(`/messages`).push(message);
    }

    getChats(userTwoId: string) {
      this.userProfile = JSON.parse(localStorage.getItem('selectedUser'));
      this.database.list(`/messages/`).valueChanges().subscribe((message: Message[]) => {
        this.messages.splice(0);
        Object.keys(message).forEach(k => {
          if((message[k].userFromId === userTwoId && message[k].userToId === this.userProfile.mykey) ||
            (message[k].userToId === userTwoId && message[k].userFromId === this.userProfile.mykey)){
              this.messages.push(message[k]);
          }
        });
        this.chat.emit(this.messages);
      });
    }

    getLastMessageForUser() {
      this.userProfile = JSON.parse(localStorage.getItem('selectedUser'));
      this.database.list(`/last-messages/${this.userProfile.mykey}`).valueChanges().subscribe(data => {
        this.database.list(`/messages/`).valueChanges().subscribe((lastmessages: Message[]) => {
          this.lastMessages.splice(0);
          for (let key of data) {
            Object.keys(lastmessages).forEach(k => {
              if (lastmessages[k].mykey === key['key'] && lastmessages[k].userToId === this.userProfile.mykey) {
                this.lastMessages.push(lastmessages[k]);
              }
            })
          }
          this.last.emit(this.lastMessages);
        })
      })
    }

    getUserLoggedSubject(): Observable<Object> {
      const user: Profile = JSON.parse(localStorage.getItem('selectedUser'));
      return this.http.post(this.APIAUTHURL + 'getSubjectUserLogged',{
        id: user.mykey,
        type: user.person_type
      });
    }
}
