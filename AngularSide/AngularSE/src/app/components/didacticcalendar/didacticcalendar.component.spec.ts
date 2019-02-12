import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DidacticcalendarComponent } from './didacticcalendar.component';

describe('DidacticcalendarComponent', () => {
  let component: DidacticcalendarComponent;
  let fixture: ComponentFixture<DidacticcalendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DidacticcalendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DidacticcalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
