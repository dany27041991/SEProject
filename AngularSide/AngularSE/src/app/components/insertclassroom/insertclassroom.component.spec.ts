import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertclassroomComponent } from './insertclassroom.component';

describe('InsertclassroomComponent', () => {
  let component: InsertclassroomComponent;
  let fixture: ComponentFixture<InsertclassroomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertclassroomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertclassroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
