import { Component, OnInit } from '@angular/core';
import {Type} from '../../utils/type';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private route: Router) {
    if (AccessToLocalStorage.getTypePerson() !== Type.Student) {
      this.route.navigate(['']);
    }
  }

  ngOnInit() {
  }

}
