import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsecretaryreportingComponent } from './detailsecretaryreporting.component';

describe('DetailsecretaryreportingComponent', () => {
  let component: DetailsecretaryreportingComponent;
  let fixture: ComponentFixture<DetailsecretaryreportingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsecretaryreportingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsecretaryreportingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
