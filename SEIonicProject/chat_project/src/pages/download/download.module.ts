import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { DownloadPage } from './download';
import {ComponentsModule} from "../../components/components.module";

@NgModule({
  declarations: [
    DownloadPage,
  ],
  imports: [
    IonicPageModule.forChild(DownloadPage),
    ComponentsModule
  ],
})
export class DownloadPageModule {}
