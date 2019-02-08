import {Component, EventEmitter} from '@angular/core';
import {ChannelMessage} from "../../models/channel/channel-message.interface";
import {ChatService} from "../../providers/chat/chat.service";
import {Observable} from "rxjs/Rx";

/**
 * Generated class for the LastChannelMessageComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'app-last-channel-message',
  templateUrl: 'last-channel-message.html'
})
export class LastChannelMessageComponent {

  lastChannelMessages: Observable<Array<ChannelMessage>>;

  constructor(private chat: ChatService) {

    this.lastChannelMessages = chat.lastChannelMessages;
  }

}
