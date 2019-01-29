import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExceptionGetDataComponent } from './exception-get-data.component';

describe('ExceptionGetDataComponent', () => {
  let component: ExceptionGetDataComponent;
  let fixture: ComponentFixture<ExceptionGetDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExceptionGetDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExceptionGetDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
