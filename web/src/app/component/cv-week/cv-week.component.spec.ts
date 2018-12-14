import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CvWeekComponent } from './cv-week.component';

describe('CvWeekComponent', () => {
  let component: CvWeekComponent;
  let fixture: ComponentFixture<CvWeekComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CvWeekComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CvWeekComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
