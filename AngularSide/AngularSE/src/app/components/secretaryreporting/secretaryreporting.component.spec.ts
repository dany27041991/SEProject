import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretaryreportingComponent } from './secretaryreporting.component';

describe('SecretaryreportingComponent', () => {
  let component: SecretaryreportingComponent;
  let fixture: ComponentFixture<SecretaryreportingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecretaryreportingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecretaryreportingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
