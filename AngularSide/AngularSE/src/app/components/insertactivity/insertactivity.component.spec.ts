import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertactivityComponent } from './insertactivity.component';

describe('InsertactivityComponent', () => {
  let component: InsertactivityComponent;
  let fixture: ComponentFixture<InsertactivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertactivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertactivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
