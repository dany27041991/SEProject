import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {SupportMaterial} from '../../models/SupportMaterial';
import {ProfessorService} from '../../services/professor.service';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {Classroom} from '../../models/Classroom';

@Component({
  selector: 'app-profreporting',
  templateUrl: './profreporting.component.html',
  styleUrls: ['./profreporting.component.css']
})
export class ProfreportingComponent implements OnInit {

  public lastname: string;
  public supportMaterial: SupportMaterial[];
  public classroomGetted: Classroom[];

  constructor(private profservice: ProfessorService, private router: Router) {
    this.lastname = AccessToLocalStorage.getUser()['lastname'];
  }

  ngOnInit() {
    this.supportMaterial = [];
    this.profservice.getSupportMaterial();
    this.profservice.supportMaterial.subscribe((data: Array<SupportMaterial>) => {
      this.supportMaterial = data as Array<SupportMaterial>;
    });
    this.classroomGetted = [];
    this.profservice.getClassroom();
    this.profservice.classrooms.subscribe((data: Array<Classroom>) => {
      this.classroomGetted = data as Array<Classroom>;
    });
  }

  reporting(form: NgForm) {
    if (!form.valid) {
      return false;
    }
    const deletecontact = confirm('Do you really want add this reporting?');
    if (deletecontact) {
      const result = this.profservice.addReporting(form.value.note, form.value.selectmaterial, form.value.classroom);
      if (result) {
        this.router.navigate(['']);
      }
    }
  }
}
