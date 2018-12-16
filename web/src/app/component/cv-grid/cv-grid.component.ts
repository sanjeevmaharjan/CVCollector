import { Component, OnInit } from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {HttpService} from '../../services/http.service';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Router} from "@angular/router";
import {OnChanges} from '@angular/core';
import {PageCvModel} from "../../models/page-cv.model";

@Component({
  selector: 'app-cv-grid',
  templateUrl: './cv-grid.component.html',
  styleUrls: ['./cv-grid.component.css']
})
export class CvGridComponent implements OnInit {

  cvs: CvModel[];

  isFirst: boolean;
  isLast: boolean;

  size: number;
  page: number = 1;

  private baseUrl = 'http://localhost:8080';

  constructor(
    private httpService: HttpService,
    private http: HttpClient,
    private router: Router
  ) {
    this.httpService.get<PageCvModel>('/api/cv/?page=0')
      .subscribe(
        cvs => {
          this.cvs = cvs.content;
          this.size = cvs.totalPages;
          if (!environment.production) {
            console.log(cvs);
          }
        }
      );
  }

  ngOnInit() {
  }

  getPage(n: number) {
    this.httpService.get<PageCvModel>('/api/cv/?page=' + (n - 1))
      .subscribe(
        cvs => {
          this.cvs = cvs.content;
          this.size = cvs.totalPages;
          if (!environment.production) {
            console.log(cvs);
          }
        }
      );
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

  open(k: number) {
    this.router.navigate(['/component/cv/' + k]);
  }

}
