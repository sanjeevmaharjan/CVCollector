import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs";
import { apiEndPoint } from "../../environments/environment";

const httpJsonOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    //'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseUrl = apiEndPoint;

  constructor(private http: HttpClient) { }

  postAsJson<T>(url: string, body: T) {
    
    return this.http.post<T>(this.baseUrl + url, body, httpJsonOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
}
