import { Component, OnInit } from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {HttpService} from '../../services/http.service';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-cv-grid',
  templateUrl: './cv-grid.component.html',
  styleUrls: ['./cv-grid.component.css']
})
export class CvGridComponent implements OnInit {

  cvs: CvModel[];

  private baseUrl = 'http://localhost:8080';

  constructor(
    private httpService: HttpService,
    private http: HttpClient
  ) {  }

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

}
