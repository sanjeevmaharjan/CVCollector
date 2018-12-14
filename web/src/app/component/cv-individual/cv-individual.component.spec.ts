import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CvIndividualComponent } from './cv-individual.component';

describe('CvIndividualComponent', () => {
  let component: CvIndividualComponent;
  let fixture: ComponentFixture<CvIndividualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CvIndividualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CvIndividualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
