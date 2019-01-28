import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';

@Component({
  selector: 'app-profreporting',
  templateUrl: './profreporting.component.html',
  styleUrls: ['./profreporting.component.css']
})
export class ProfreportingComponent implements OnInit {

  public lastname: string;

  constructor() {
    this.lastname = AccessToLocalStorage.getUser()['lastname'];
  }

  ngOnInit() {
  }

}
