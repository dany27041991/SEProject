import {Component, Input} from '@angular/core';
import {RatingTeachingMaterial} from "../../models/rating/RatingTeachingMaterial";

/**
 * Generated class for the LastRateProfessorComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'app-last-rate-professor',
  templateUrl: 'last-rate-professor.html'
})
export class LastRateProfessorComponent{

  @Input() lastRateRes: RatingTeachingMaterial;

  constructor() {

  }

}
