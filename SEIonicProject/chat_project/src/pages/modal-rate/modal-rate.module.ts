import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ModalRatePage } from './modal-rate';
import {ComponentsModule} from "../../components/components.module";

@NgModule({
  declarations: [
    ModalRatePage,
  ],
  imports: [
    IonicPageModule.forChild(ModalRatePage),
    ComponentsModule
  ],
})
export class ModalRatePageModule {}
