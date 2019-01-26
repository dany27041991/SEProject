import {Cookie} from 'ng2-cookies/ng2-cookies';

export class AccessToLocalStorage {

  constructor() {}

  public static getTypePerson(): number {
    const person = JSON.parse(localStorage.getItem('Person'));
    if (JSON.parse(localStorage.getItem('Person'))) {
      return person['person_type'];
    }
    return 0;
  }

  public static getJwt(): boolean {
    const jwt: string = Cookie.get('Jwt');
    if (jwt) {
      return true;
    }
    return false;
  }
}

