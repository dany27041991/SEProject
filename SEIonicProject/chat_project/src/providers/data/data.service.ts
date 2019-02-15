import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from '@angular/fire/database';
import { User, database } from 'firebase/app';
import { Profile } from '../../models/profile/profile.interface';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class DataProvider {

  private APIAUTHURL = 'http://localhost:8090/user/faculty/';
  profileObject: AngularFireObject<Profile>;
  profileList: AngularFireList<Profile>;

  constructor(private database: AngularFireDatabase, private http: HttpClient) {
  }

  async saveProfile(user: User, profile: Profile) {
    this.profileObject = this.database.object(`/profiles/${user.uid}`);

    const allUser = JSON.parse(localStorage.getItem('AllUser'));
    const userFilter = allUser.find(obj => obj.username === user.email);
    profile.mykey = userFilter['id'];
    profile.dateOfBirth = userFilter['birthdate'];
    profile.firstName = userFilter['firstname'];
    profile.lastName = userFilter['lastname'];
    profile.person_type = userFilter['person_type'];
    profile.email = user.email;
    try {
      localStorage.setItem('selectedUser', JSON.stringify(profile));
      await this.profileObject.set(profile);
      return true;
    }
    catch(e) {
      console.error(e);
      return false;
    }
  }

  getProfile(user: User) {
    this.profileObject = this.database.object(`/profiles/${user.uid}`);
    return this.profileObject.valueChanges();
  }

  searchUser(firstName: string) {
    const query = this.database.list('/profiles', query => query.orderByChild('firstName').equalTo(firstName));

    return query.valueChanges();
  }

  setUserOnline(profile: Profile) {

      if(profile){
        const ref = database().ref(`online-users/${profile.mykey}`);

        try {
          ref.update({ ...profile});
          ref.onDisconnect().remove();
        }
        catch(e) {
          console.error(e);
        }
      }
  }

  getOnlineUsers(): AngularFireList<Profile[]> {
    return <any>this.database.list(`online-users`).valueChanges();
  }

  deleteUserLogoutOnline(key: string) {
    database().ref(`/online-users/${key}`).remove();
  }

  getAllUsers() {
    return <any>this.database.list(`profiles`).valueChanges();
  }

  addRateLesson(id: number, rate: number, idStudent: number) {
    return this.http.post(this.APIAUTHURL + 'addratinglesson',
      {
        id: id,
        rate: rate,
        id_student: idStudent
      }, {observe: 'response'});
  }

  /*getAuthenticatedUserProfile() {
    return this.auth.getAuthenticatedUser().pipe(map(user => user.uid), mergeMap(authId => this.database.object(`profiles/${authId}`).snapshotChanges()))
  }*/
}
