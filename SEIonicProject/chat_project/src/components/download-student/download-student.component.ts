import { Component } from '@angular/core';

/**
 * Generated class for the DownloadStudentComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'app-download-student',
  templateUrl: 'download-student.component.html'
})
export class DownloadStudentComponent {

  text: string;

  constructor() {
    console.log('Hello DownloadStudentComponent Component');
    this.text = 'Hello World';
  }

}
