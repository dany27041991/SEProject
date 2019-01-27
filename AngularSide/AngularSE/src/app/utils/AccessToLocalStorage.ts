export class AccessToLocalStorage {
  constructor() {}
  public static getTypePerson(): number {
    const person = JSON.parse(localStorage.getItem('Person'));
    if (JSON.parse(localStorage.getItem('Person'))) {
      return person['person_type'];
    }
    return 0;
  }
}

