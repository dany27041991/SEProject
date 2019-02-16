import {Component, Input} from '@angular/core';
import {UploadInterface} from "../../models/upload/upload.interface";

/**
 * Generated class for the LastUploadMaterialComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'app-last-upload-material',
  templateUrl: 'last-upload-material.html'
})
export class LastUploadMaterialComponent {

  @Input() lastUpload: Array<UploadInterface>;

  constructor() {
  }

}
