import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {RouteGuardService} from './route-guard.service.guard';
import {HomeComponent} from './components/home/home.component';
import {ExceptionGetDataComponent} from './exceptions/exception-get-data/exception-get-data.component';
import {StudentComponent} from './components/student/student.component';
import {ProfessorComponent} from './components/professor/professor.component';
import {SecretaryComponent} from './components/secretary/secretary.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full',
    component: HomeComponent
  },
  {
    path: 'error',
    component: ExceptionGetDataComponent
  },
  {
    path: 'user/student/:id',
    component: StudentComponent,
    canActivate: [RouteGuardService]
  },
  {
    path: 'user/professor/:id',
    component: ProfessorComponent,
    canActivate: [RouteGuardService],
  },
  {
    path: 'user/secretary/:id',
    component: SecretaryComponent,
    canActivate: [RouteGuardService]
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [
    RouterModule
  ],
  providers: [
    RouteGuardService
  ]
})
export class RoutingModuleModule { }
