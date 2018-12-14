import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';
import { apiEndPoint } from '../../environments/environment';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/internal/observable/of';
import {LoginModel} from '../models/login.model';

const postOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

const loginOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': 'Basic Y3JtQ2xpZW50MTpjcm1TdXBlclNlY3JldA=='
  })
};

const getOptions = {
  headers: new HttpHeaders({
    'Authorization': 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY3ZfY29sbGVjdG9yIl0sInVzZXJfbmFtZSI6InNhbmplZXYiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdLCJleHAiOjE1NDQ4MDE2NDksImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiLCJST0xFX0NMSUVOVCJdLCJqdGkiOiI0ZmE5YjlmMC1kMWNmLTQxZjgtYjU5MC04NDk2N2E4NWFlZGQiLCJjbGllbnRfaWQiOiJjcm1DbGllbnQxIn0.Pfdoibq-ql9KhsWj9cwxMjowGdq5SiK6eLwslPyvR9EIpO75Pt54g523iF7Iv2pc885Kt6U0wIzNIFc6jx6hj3IosJDu5mM06h7O0MhqfpdpD4o3yc6aSt3sJJoTfOEHU_rYm1OaE37gXvot5rYyYlooKQL1WjCj5-GvDXnok9MiIkLLTrhBTztmbcDxQK8y3upcqudfcqF6wFQRFgkoNVfidJyOQ4vdmARVZGn_EUCRnG6-xvhkNhpMF7gUSmHEDvcdThzts_MsvAkIImWXlQzFwLZn7EeW7Fax9asAvgsYxDEtDrndjQX9GmwFZCMs55Xfq1HqVU4Bl7N_PYx6Cw'
  })
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseUrl = apiEndPoint;

  constructor(private http: HttpClient) { }

  public getAll<T>(url: string, op: string = ''): Observable<T[]> {
    return this.http.get<T[]>(this.baseUrl + url, getOptions)
      .pipe(
        catchError(this.handleError(op, []))
      );
  }

  public get<T>(url: string, op: string = ''): Observable< any | T> {
    return this.http.get<T>(this.baseUrl + url, getOptions)
      .pipe(
        catchError(this.handleError(op, []))
      );
  }

  postAsJson<T>(url: string, body: T, op: string = '') {
        return this.http.post<T>(this.baseUrl + url, body, postOptions)
      .pipe(
        catchError(this.handleError(op, body))
      );
  }

  public login(user: LoginModel): Observable<any> {

    console.log(loginOptions);
    return this.http.post(this.baseUrl + '/oauth/token', user, loginOptions)
      .pipe(
        catchError(this.handleError('login', user))
      );
  }

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
    console.log(Date() + msg);
  }
}
