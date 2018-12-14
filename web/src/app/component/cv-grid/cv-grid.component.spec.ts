import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CvGridComponent } from './cv-grid.component';

describe('CvGridComponent', () => {
  let component: CvGridComponent;
  let fixture: ComponentFixture<CvGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CvGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CvGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
