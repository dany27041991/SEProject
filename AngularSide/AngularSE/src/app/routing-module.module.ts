import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {RouteGuardService} from './route-guard.service';
import {HomeComponent} from './components/home/home.component';
import {ExceptionGetDataComponent} from './exceptions/exception-get-data/exception-get-data.component';

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
