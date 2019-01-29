import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {SupportMaterial} from '../../models/SupportMaterial';
import {ProfessorService} from '../../services/professor.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-profreporting',
  templateUrl: './profreporting.component.html',
  styleUrls: ['./profreporting.component.css']
})
export class ProfreportingComponent implements OnInit {

  public lastname: string;
  public supportMaterial: SupportMaterial[];

  constructor(private profservice: ProfessorService) {
    this.supportMaterial = [];
    this.lastname = AccessToLocalStorage.getUser()['lastname'];
    this.profservice.supportMaterial.subscribe((data: SupportMaterial[]) => {
      this.supportMaterial = data as Array<SupportMaterial>;
    });
  }

  ngOnInit() {
    this.profservice.getSupportMaterial();
  }

  reporting(form: NgForm) {
    if (!form.valid) {
      return false;
    }
    console.log(form.value);
  }
}
