import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import { catchError, map, tap } from 'rxjs/operators';
import {of} from "rxjs/internal/observable/of";

@Injectable({
  providedIn: 'root'
})
export class CvService {
  private baseUrl = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

  public getAll<T>(url: string): Observable<T[]> {
    return this.http.get<T[]>(this.baseUrl + url)
      .pipe(
        catchError(this.handleError('getCvs', []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
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

  public log(msg: string) {
    console.log(msg);
  }
}
