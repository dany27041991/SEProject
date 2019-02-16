import {Component, ElementRef, ViewChild} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { GoogleMaps, GoogleMap, LatLng, GoogleMapsEvent, Marker, MarkerOptions } from '@ionic-native/google-maps'

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
  @ViewChild('map') mapElement: ElementRef;
  map: GoogleMap;

  public latitude: number;
  public longitude: number;
  public name: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, private maps: GoogleMaps) {
  }

  ionViewDidLoad() {}

  ionViewWillLoad() {
    this.latitude = this.navParams.get('latitude');
    this.longitude = this.navParams.get('longitude');
    this.name = this.navParams.get('name');
  }

  ngAfterViewInit() {
    let loc: LatLng = new LatLng(this.latitude, this.longitude);
    this.initMap();
    this.map.one(GoogleMapsEvent.MAP_READY).then(() => {
      this.moveCamera(loc);
      this.createMarker(loc, this.name).then((marker: Marker) => {
        marker.showInfoWindow();
      }).catch(err => {
        console.log(err);
      });
    }).catch(err => {
      console.log(err);
    });
  }

  initMap() {
    let element = this.mapElement.nativeElement;
    this.map = this.maps.create(element);
  }

  moveCamera(loc: LatLng) {
    //let options: CameraPosition = {
    let options = {
      target: loc,
      zoom: 15,
      tilt: 10
    };
    this.map.moveCamera(options);
  }

  createMarker(loc: LatLng, title: string) {
    let markerOptions: MarkerOptions = {
      position: loc,
      title: title
    };
    return this.map.addMarker(markerOptions);
  }

}
