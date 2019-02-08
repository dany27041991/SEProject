import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertstudycourseComponent } from './insertstudycourse.component';

describe('InsertstudycourseComponent', () => {
  let component: InsertstudycourseComponent;
  let fixture: ComponentFixture<InsertstudycourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertstudycourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertstudycourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
