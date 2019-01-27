export class AccessToLocalStorage {
  constructor() {}

  public static getTypePerson(): number {
    const person = JSON.parse(localStorage.getItem('Person'));
    if (JSON.parse(localStorage.getItem('Person'))) {
      return person['person_type'];
    }
    return 0;
  }

  public static getPerson(): boolean {
    const person = JSON.parse(localStorage.getItem('Person'));
    if (person) {
      return true;
    }
    return false;
  }
}

