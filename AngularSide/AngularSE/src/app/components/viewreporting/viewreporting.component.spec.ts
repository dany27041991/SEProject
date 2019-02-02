import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewreportingComponent } from './viewreporting.component';

describe('ViewreportingComponent', () => {
  let component: ViewreportingComponent;
  let fixture: ComponentFixture<ViewreportingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewreportingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewreportingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
