import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {TypeLoggedInterface} from '../../interfaces/TypeLoggedInterface';
import {Type} from '../../utils/type';
import {AuthService} from '../../services/auth.service';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() public checkPerson: TypeLoggedInterface;
  public secretary = Type.Secretary;
  public professor = Type.Professor;

  constructor(private router: Router, private auth: AuthService, private cookie: CookieService) { }

  ngOnInit() {
    if (this.cookie.get('Jwt') && AccessToLocalStorage.getPerson()) {
      this.checkPerson.logged = true;
      this.checkPerson.type = AccessToLocalStorage.getTypePerson();
    }
  }

  goToNotifications(): void {
    if (AccessToLocalStorage.getTypePerson() === Type.Professor) {
      this.router.navigate(['user/professor/' + AccessToLocalStorage.getUser()['id'] + '/profreporting']);
    }
  }

  goToUploadMaterial(): void {
    if (AccessToLocalStorage.getTypePerson() === Type.Professor) {
      this.router.navigate(['user/professor/' + AccessToLocalStorage.getUser()['id'] + '/upload']);
    }
  }

  goToProfile(): void {
    if (AccessToLocalStorage.getTypePerson() === Type.Professor) {
      this.router.navigate(['user/professor/' + AccessToLocalStorage.getUser()['id']]);
    }
  }
}
