import { Component, OnInit } from '@angular/core';
import {isNullOrUndefined} from '@swimlane/ngx-datatable/release/utils';
import {CvModel} from '../../models/cv/cv.model';

@Component({
  selector: 'app-preview',
  templateUrl: '../../shared/cv-view/cv-view.component.html',
  styleUrls: ['../../shared/cv-view/cv-view.component.css']
})
export class PreviewComponent implements OnInit {
  cv: CvModel;

  tab = 1;

  constructor() { }

  ngOnInit() {
    const cvFromLocal = localStorage.getItem('cv-data');
    if (!isNullOrUndefined(cvFromLocal)) {
      this.cv = JSON.parse(cvFromLocal);
    }
  }

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
