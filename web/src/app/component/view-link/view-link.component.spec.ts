import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewLinkComponent } from './view-link.component';

describe('ViewLinkComponent', () => {
  let component: ViewLinkComponent;
  let fixture: ComponentFixture<ViewLinkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewLinkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewLinkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
