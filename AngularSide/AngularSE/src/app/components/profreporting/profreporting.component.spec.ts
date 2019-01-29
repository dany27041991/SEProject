import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfreportingComponent } from './profreporting.component';

describe('ProfreportingComponent', () => {
  let component: ProfreportingComponent;
  let fixture: ComponentFixture<ProfreportingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfreportingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfreportingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
