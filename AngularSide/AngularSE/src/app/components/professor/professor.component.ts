import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Type} from '../../utils/type';
import {Router} from '@angular/router';
import {Professor} from '../../models/Professor';
import {ProfessorService} from '../../services/professor.service';
import {SupportMaterial} from '../../models/SupportMaterial';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})
export class ProfessorComponent implements OnInit {

  public professor: Professor;
  public supportMaterial: SupportMaterial[];

  constructor(private route: Router, private profservice: ProfessorService) {
    if (AccessToLocalStorage.getTypePerson() !== Type.Professor) {
      this.route.navigate(['']);
    } else {
      this.professor = this.profservice.getSubject();
    }
  }

  ngOnInit() {
  }

}
