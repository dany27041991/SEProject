import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { RatinglessonPage } from './ratinglesson';
import {ComponentsModule} from "../../components/components.module";

@NgModule({
  declarations: [
    RatinglessonPage,
  ],
  imports: [
    IonicPageModule.forChild(RatinglessonPage),
    ComponentsModule
  ],
})
export class RatinglessonPageModule {}
