import { Component, OnInit } from '@angular/core';
import {AccessToLocalStorage} from '../../utils/AccessToLocalStorage';
import {Observable} from 'rxjs';
import {ProfessorService} from '../../services/professor.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {ResponseInterface} from '../../interfaces/ResponseInterface';
import {Type} from '../../utils/type';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  public lastname: string;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  constructor(private professorService: ProfessorService, private router: Router, private auth: AuthService) {
    this.lastname = AccessToLocalStorage.getUser()['lastname'];
  }

  ngOnInit() {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.professorService.pushFileToStorage(this.currentFileUpload, AccessToLocalStorage.getUser()['id'],
      AccessToLocalStorage.getUser()['subject']).subscribe(event => {
        switch (event['status']) {
        case 417: {
          this.auth.logout();
          break;
        }
        case 403: {
          this.auth.logout();
          break;
        }
        case 504: {
          this.auth.logout();
          break;
        }
        case 500: {
          this.router.navigate(['error', {code: 500,
            message: 'There was a problem loading {Max size required 10Mb}. ' +
            'If the problem persists please log in again or contact the administrator.'}]);
          break;
        }
        default: {
          if (event.type === HttpEventType.UploadProgress) {
            this.progress.percentage = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            console.log('File is completely uploaded!');
          }
          break;
        }
      }
        /*if (event.type === HttpEventType.UploadProgress) {
          this.progress.percentage = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }*/
    });

    this.selectedFiles = undefined;
  }
}
