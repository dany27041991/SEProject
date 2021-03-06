import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {RoutingModuleModule} from './routing-module.module';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import {FormsModule} from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {AuthService} from './services/auth.service';
import {CompareValidatorDirective} from './shared/compare-validator.directive';
import { HomeComponent } from './components/home/home.component';
import { ExceptionGetDataComponent } from './exceptions/exception-get-data/exception-get-data.component';
import { StudentComponent } from './components/student/student.component';
import { ProfessorComponent } from './components/professor/professor.component';
import { SecretaryComponent } from './components/secretary/secretary.component';
import {CookieService} from 'ngx-cookie-service';
import { ProfreportingComponent } from './components/profreporting/profreporting.component';
import { InsertstudycourseComponent } from './components/insertstudycourse/insertstudycourse.component';
import { InsertsubjectComponent } from './components/insertsubject/insertsubject.component';
import { InsertclassroomComponent } from './components/insertclassroom/insertclassroom.component';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'node_modules/ng-pick-datetime';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { InsertuserComponent } from './components/insertuser/insertuser.component';
import { InsertactivityComponent } from './components/insertactivity/insertactivity.component';
import { SuccessfulComponent } from './messages/successful/successful.component';
import { UploadComponent } from './components/upload/upload.component';
import { ViewreportingComponent } from './components/viewreporting/viewreporting.component';
import { SecretaryreportingComponent } from './components/secretaryreporting/secretaryreporting.component';
import { DetailsecretaryreportingComponent } from './components/detailsecretaryreporting/detailsecretaryreporting.component';
import { DidacticcalendarComponent } from './components/didacticcalendar/didacticcalendar.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    CompareValidatorDirective,
    HomeComponent,
    ExceptionGetDataComponent,
    StudentComponent,
    ProfessorComponent,
    SecretaryComponent,
    ProfreportingComponent,
    InsertstudycourseComponent,
    InsertsubjectComponent,
    InsertclassroomComponent,
    InsertuserComponent,
    InsertactivityComponent,
    ProfreportingComponent,
    SuccessfulComponent,
    UploadComponent,
    ViewreportingComponent,
    SecretaryreportingComponent,
    DetailsecretaryreportingComponent,
    DidacticcalendarComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    HttpClientModule,
    RoutingModuleModule,
    FormsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    NoopAnimationsModule
  ],
  providers: [AuthService, CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
