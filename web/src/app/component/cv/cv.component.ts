import { Component, OnInit } from '@angular/core';
import { CvModel } from '../../models/cv/cv.model';
import {CvService} from "./cv.service";
import {Observable} from "rxjs/Observable";
import {catchError, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {of} from "rxjs/internal/observable/of";
import {HttpService} from "../../services/http.service";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

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
}
