import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { AngularFireModule } from '@angular/fire';
import { AngularFireDatabaseModule} from '@angular/fire/database';

import { MyApp } from './app.component';
import { FIREBASE_CONFIG } from './app.firebase.config';
import { AuthProvider } from '../providers/auth/auth.service';
import { AngularFireAuthModule } from '@angular/fire/auth';
import { DataProvider } from '../providers/data/data.service';
import { FormsModule } from '@angular/forms';
import { ChatService } from '../providers/chat/chat.service';
import {HttpClientModule} from "@angular/common/http";
import {ProfessorProvider} from "../providers/professor/professor.service";
import {SecretaryProvider} from "../providers/secretary/secretary.service";
import {StudentProvider} from "../providers/student/student.service";
import {GoogleMaps} from "@ionic-native/google-maps";

@NgModule({
  declarations: [
    MyApp
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    AngularFireModule.initializeApp(FIREBASE_CONFIG),
    AngularFireAuthModule,
    AngularFireDatabaseModule,
    FormsModule,
    HttpClientModule
  ],
  bootstrap: [
    IonicApp
  ],
  entryComponents: [
    MyApp
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AuthProvider,
    DataProvider,
    ChatService,
    HttpClientModule,
    ProfessorProvider,
    SecretaryProvider,
    StudentProvider,
    GoogleMaps
  ]
})
export class AppModule {}
