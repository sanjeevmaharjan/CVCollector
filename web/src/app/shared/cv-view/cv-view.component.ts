import {Component, Input, OnInit} from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';

@Component({
  selector: 'app-cv-view',
  templateUrl: './cv-view.component.html',
  styleUrls: ['./cv-view.component.css']
})
export class CvViewComponent implements OnInit {

  @Input() cv: CvModel | null;

  tab = 1;

  constructor() { }

  ngOnInit() {}

  getGender(id: number): string {
    switch (id) {
      case 0:
        return 'Unspecified';
      case 1:
        return 'Male';
      case 2:
        return 'Female';
      default:
        return 'Unspecified';
    }
  }

  selectTab(id: number): void {
    this.tab = id;
  }

}
