import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {Router} from '@angular/router';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})
export class ProfessorComponent implements OnInit {

  constructor(private route: Router) {
    if (AccessToLocalStorage.getTypePerson() !== Type.Professor) {
      this.route.navigate(['']);
    }
  }

  ngOnInit() {
  }

}
