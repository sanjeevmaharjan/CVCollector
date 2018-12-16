import { Component, OnInit } from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {HttpService} from '../../services/http.service';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Router} from "@angular/router";
import {OnChanges} from '@angular/core';

@Component({
  selector: 'app-cv-grid',
  templateUrl: './cv-grid.component.html',
  styleUrls: ['./cv-grid.component.css']
})
export class CvGridComponent implements OnInit {

  cvs: CvModel[];

  size: number = 0;

  page: number = 1;

  private baseUrl = 'http://localhost:8080';

  constructor(
    private httpService: HttpService,
    private http: HttpClient,
    private router: Router
  ) {

  }

  ngOnInit() {
    this.httpService.getAll<CvModel>('/api/cv/')
      .subscribe(
        cvs => {
          this.cvs = cvs;
          if (!environment.production) {
            console.log(cvs);
          }
        }
      );

    this.httpService.get('/api/cv/getNumPages')
      .subscribe(
        num => {
          console.log(num);
          this.size = num;
        }
      );
  }

  ngOnChanges() {

  }

  getPage(n: number) {
    this.httpService.getAll<CvModel>('/api/cv/?page=' + n)
      .subscribe(
        cvs => {
          this.cvs = cvs;
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
