import {Component, Input, OnInit} from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {HttpService} from "../../services/http.service";
import {HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-cv-view',
  templateUrl: './cv-view.component.html',
  styleUrls: ['./cv-view.component.css']
})
export class CvViewComponent implements OnInit {

  @Input() cv: CvModel | null;

  tab = 3;

  constructor(private httpService: HttpService) { }

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

  print(): void {

    this.httpService.get(
      '/api/cv/getPdf/' + this.cv.links).subscribe(
      (response) => {
        const mediaType = 'application/pdf';
        const blob = new Blob([response._body], {type: mediaType});
        const filename = 'test.pdf';
        const url = window.URL.createObjectURL(blob);
        window.open(url);
      });
  }

}
