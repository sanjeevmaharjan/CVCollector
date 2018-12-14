import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CvTodayComponent } from './cv-today.component';

describe('CvTodayComponent', () => {
  let component: CvTodayComponent;
  let fixture: ComponentFixture<CvTodayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CvTodayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CvTodayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
