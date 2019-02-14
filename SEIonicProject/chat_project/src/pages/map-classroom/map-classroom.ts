import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation/ngx'

/**
 * Generated class for the MapClassroomPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-map-classroom',
  templateUrl: 'map-classroom.html',
})
export class MapClassroomPage {

  public latitude: number;
  public longitude: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, private geolocation: Geolocation) {
  }

  ionViewDidLoad() {
  }

  ionViewWillLoad() {
    this.latitude = this.navParams.get('latitude');
    this.longitude = this.navParams.get('longitude');
    console.log(this.latitude, this.longitude);
    this.getMap();
  }

  getMap() {

    let mapOptions = {
      center: new google.maps.LatLng(0, 0),
      zoom: 1,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    let map = new google.maps.Map(document.getElementById("map"), mapOptions);


    let latLong = new google.maps.LatLng(this.latitude, this.longitude);

    let marker = new google.maps.Marker({
      position: latLong
    });

    marker.setMap(map);
    map.setZoom(15);
    map.setCenter(marker.getPosition());
  }

}
