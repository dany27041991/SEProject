import { NgModule } from '@angular/core';
import { IonicModule } from 'ionic-angular';

import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { EditProfileFormComponent } from './edit-profile-form/edit-profile-form.component';
import { ProfileViewComponent } from './profile-view/profile-view.component';
import { ProfileSearchComponent } from './profile-search/profile-search.component';
import { SendMessageBoxComponent } from './send-message-box/send-message-box.component';
import { OnlineUsersComponent } from './online-users/online-users.component';
import { LastMessageListComponent } from './last-message-list/last-message-list.component';
import { CommonModule } from '@angular/common';
import { DownloadStudentComponent } from './download-student/download-student.component';
import { LastChannelMessageComponent } from './last-channel-message/last-channel-message';
import { LastUploadMaterialComponent } from './last-upload-material/last-upload-material';
import { LastRateProfessorComponent } from './last-rate-professor/last-rate-professor';
import { RatelessonComponent } from './ratelesson/ratelesson';
import { LastChangeClassroomProfessorComponent } from './last-change-classroom-professor/last-change-classroom-professor';
import { LastChangeClassroomStudentComponent } from './last-change-classroom-student/last-change-classroom-student';
import { LastReportingProfessorComponent } from './last-reporting-professor/last-reporting-professor';

@NgModule({
    declarations: [
      LoginFormComponent,
      RegisterFormComponent,
      EditProfileFormComponent,
      ProfileViewComponent,
      ProfileSearchComponent,
      SendMessageBoxComponent,
      OnlineUsersComponent,
      LastMessageListComponent,
      DownloadStudentComponent,
      LastChannelMessageComponent,
    LastUploadMaterialComponent,
    LastRateProfessorComponent,
    RatelessonComponent,
    LastChangeClassroomProfessorComponent,
    LastChangeClassroomStudentComponent,
    LastReportingProfessorComponent
    ],
    imports: [
      IonicModule,
      CommonModule
    ],
    exports: [
      LoginFormComponent,
      RegisterFormComponent,
      EditProfileFormComponent,
      ProfileViewComponent,
      ProfileSearchComponent,
      SendMessageBoxComponent,
      OnlineUsersComponent,
      LastMessageListComponent,
      DownloadStudentComponent,
      LastChannelMessageComponent,
    LastUploadMaterialComponent,
    LastRateProfessorComponent,
    RatelessonComponent,
    LastChangeClassroomProfessorComponent,
    LastChangeClassroomStudentComponent,
    LastReportingProfessorComponent
    ]
})

export class ComponentsModule {}
