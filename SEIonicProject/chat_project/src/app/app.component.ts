import {Component, OnInit} from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import {AuthProvider} from "../providers/auth/auth.service";
import {Response} from "../models/response/response.interface";
import { AngularFireAuth } from '@angular/fire/auth';

@Component({
  templateUrl: 'app.html'
})
export class MyApp implements OnInit{
  ngOnInit(): void {
    this.auth.getAllUser().subscribe((data: Response) => {
      const arrayUser = data.response;
      Object.keys(arrayUser).forEach(k => {
        this.authFirebase.auth.createUserWithEmailAndPassword(arrayUser[k].username, arrayUser[k].password).catch(function(error) {
          console.log(error);
        });
      });
      arrayUser.filter(obj => {
        delete obj.password;
        return true;
      });
      localStorage.setItem('AllUser', JSON.stringify(arrayUser));
    }),httpResp => {
      this.preLoad = false;
    };
  }
  // classe che si vuole caricare. in questo caso si riferisce alla login.ts
  rootPage: string;
  preLoad: boolean = false;

  constructor( platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen, private auth: AuthProvider, private authFirebase: AngularFireAuth) {
    //this.auth.getAuthenticatedUser().subscribe(auth => {
      //!auth ? this.rootPage = 'LoginPage' : this.rootPage = 'MessagePage';
    //})


    platform.ready().then(() => {

      this.rootPage = 'LoginPage';
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }
}

