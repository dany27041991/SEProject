import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {TypeLoggedInterface} from '../../interfaces/TypeLoggedInterface';
import {Type} from '../../utils/type';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() public checkPerson: TypeLoggedInterface;
  public secretary = Type.Secretary;
  public professor = Type.Professor;

  constructor(private router: Router) { }

  ngOnInit() {
  }

}
