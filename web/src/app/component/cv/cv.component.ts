import { Component, OnInit } from '@angular/core';
import { CvModel } from '../../models/cv/cv.model';
import {CvService} from "./cv.service";
import {Observable} from "rxjs/Observable";
import {catchError, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {of} from "rxjs/internal/observable/of";

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

  cvs: CvModel[];

  private baseUrl = 'http://localhost:8080';

  constructor(
    private cvService: CvService,
    private http: HttpClient
  ) {  }

  ngOnInit() {
    this.cvService.getAll<CvModel>("/cv/")
      .subscribe(
        cvs => {
          this.cvs = cvs;
          this.log(this.cvs);
        }
      );
  }

  public getAll<T>(url: string): Observable<T[]> {
    return this.http.get<T[]>(this.baseUrl + url)
      .pipe(
        tap(cvs => this.log(cvs)),
        catchError(this.handleError('getCvs', []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - Name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  public handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  public log(msg: any) {
    console.log(msg);
  }

}
