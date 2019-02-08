import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertsubjectComponent } from './insertsubject.component';

describe('InsertsubjectComponent', () => {
  let component: InsertsubjectComponent;
  let fixture: ComponentFixture<InsertsubjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertsubjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertsubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
