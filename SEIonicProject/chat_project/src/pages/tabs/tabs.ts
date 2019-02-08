import { Component } from '@angular/core';
import { IonicPage } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html',
})
export class TabsPage {

  tab1Root: string;
  tab2Root: string;
  tab3Root: string;
  tab4Root: string;
  public type: number = 0;

  constructor() {
    this.tab1Root = 'InboxPage';
    this.tab2Root = 'ChannelsPage';
    this.tab3Root = 'ProfilePage';
    this.tab4Root = 'DownloadPage';
    setTimeout(()=>{
      this.type = JSON.parse(localStorage.getItem('selectedUser'))['person_type'];
    }, 2000);
  }
}
