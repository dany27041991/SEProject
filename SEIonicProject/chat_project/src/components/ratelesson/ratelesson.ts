import {Component, Input} from '@angular/core';
import {RatingTeachingMaterial} from "../../models/rating/RatingTeachingMaterial";
import {RatelessonInterface} from "../../models/ratelesson/ratelesson.interface";

/**
 * Generated class for the RatelessonComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'app-ratelesson',
  templateUrl: 'ratelesson.html'
})
export class RatelessonComponent {

  @Input() lastRateLesson: RatelessonInterface;

  constructor() {

  }

}
