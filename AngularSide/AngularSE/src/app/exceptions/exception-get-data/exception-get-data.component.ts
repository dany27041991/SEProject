import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {ResponseInterface} from '../../interfaces/ResponseInterface';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-exception-get-data',
  templateUrl: './exception-get-data.component.html',
  styleUrls: ['./exception-get-data.component.css']
})
export class ExceptionGetDataComponent implements OnInit {

  public code: string;
  public message: string;

  constructor(private route: ActivatedRoute) {
    this.code = this.route.snapshot.paramMap.get('code');
    this.message = this.route.snapshot.paramMap.get('message');
  }

  ngOnInit() {
  }

}
