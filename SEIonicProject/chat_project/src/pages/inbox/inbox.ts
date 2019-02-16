import {Component, OnInit} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {ChatService} from "../../providers/chat/chat.service";
import {map} from "rxjs/internal/operators";
import {StudentProvider} from "../../providers/student/student.service";
import {UploadInterface} from "../../models/upload/upload.interface";
import {ProfessorProvider} from "../../providers/professor/professor.service";
import {RatingTeachingMaterial} from "../../models/rating/RatingTeachingMaterial";
import {RatelessonInterface} from "../../models/ratelesson/ratelesson.interface";
import {SecretaryProvider} from "../../providers/secretary/secretary.service";
import {ProfessorInterface} from "../../models/professor/professor.interface";
import {StudentInterface} from "../../models/student/student.interface";
import {CalendarInterface} from "../../models/calendar/calendar.interface";
import {ReportingInterface} from "../../models/reporting/reporting.interface";

@IonicPage()
@Component({
  selector: 'page-inbox',
  templateUrl: 'inbox.html',
})
export class InboxPage implements OnInit{

  public type_person: number;
  lastUpload : Array<UploadInterface>;
  lastRateRes: RatingTeachingMaterial;
  lastRateLesson: RatelessonInterface;
  public professor: ProfessorInterface;
  public stud: StudentInterface;
  public id: number;
  public lastCalendarProf: CalendarInterface;
  public lastCalendarStud: CalendarInterface;
  public lastReporting: ReportingInterface;

  constructor(private sec: SecretaryProvider, public navCtrl: NavController, public navParams: NavParams, private chat: ChatService,
              private student: StudentProvider, private prof: ProfessorProvider) {
    this.type_person = JSON.parse(localStorage.getItem('selectedUser'))['person_type'];
    this.id = JSON.parse(localStorage.getItem('selectedUser'))['mykey'];
    if(this.type_person === 3) {
      this.chat.getUserLoggedSubject().pipe(map(data => data['response'])).subscribe((res: Array<number>) => {
        this.student.getLastUploadMaterial(res).subscribe(data =>
          this.lastUpload = data.body['response']
        )
      });

      this.sec.getStudentDetails(this.id).pipe(map(data => data.body['response'])).subscribe((res: StudentInterface) => {
        this.stud = res;
        this.sec.getLastClassroomChangeByStudycourse(this.stud.studycourse).pipe(map(data => data.body['response'])).subscribe((res: CalendarInterface) => {
          this.lastCalendarStud = res;
        });
      });
    }
    if(this.type_person === 2) {
      this.prof.rateDownloadMaterial().pipe(map(data => data.body['response'])).subscribe((res: Array<RatingTeachingMaterial>) => {
        if(res.length) {
          let lastRate: Array<RatingTeachingMaterial> = res;
          lastRate = lastRate.filter(function (res) {
            return (res.professor.firstName === JSON.parse(localStorage.getItem('selectedUser'))['firstName'] &&
              res.professor.lastName === JSON.parse(localStorage.getItem('selectedUser'))['lastName']);
          });
          lastRate.reverse();
          this.lastRateRes = lastRate[0];
        }
      });

      this.prof.rateLesson().subscribe((res)=> {
        res.reverse();
        this.lastRateLesson = res[0];
      });

      this.sec.getProfessorDetails(this.id).pipe(map(data => data.body['response'])).subscribe((res: ProfessorInterface) => {
        this.professor = res;
        this.sec.getLastClassroomChangeBySubject(this.professor.subject).pipe(map(data => data.body['response'])).subscribe((res: CalendarInterface) => {
          this.lastCalendarProf = res;
        });
        this.sec.getLastReportingByProfessor(this.professor.id).pipe(map(data => data.body['response'])).subscribe((result: ReportingInterface) => {
          this.lastReporting = result;
        });
      });
    }
  }

  ionViewDidLoad() {
  }

  ngOnInit(): void {
    this.chat.getLastChannelMessages();
  }

  navigateToSearchUserPage() {
    this.navCtrl.push('SearchUserPage');
  }

}
