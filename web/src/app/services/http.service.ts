import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http';
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

const getOptions = {
  headers: new HttpHeaders({
    'Authorization': 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY3ZfY29sbGVjdG9yIl0sInVzZXJfbmFtZSI6InNhbmplZXYiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdLCJleHAiOjE1NDQ5NzYxOTEsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiLCJST0xFX0NMSUVOVCJdLCJqdGkiOiI2ZmM0MjhkZC0xN2RlLTRjMDktOGM5Ni05Y2RlNjMzZTc4YzciLCJjbGllbnRfaWQiOiJjcm1DbGllbnQxIn0.hFjgvG4Aypfom6ANRTSY0iUYbBqBs8L-hO31NZIfqkAHlz2dfxKWrL_7jBfySCFUH57nL08JAp19Bnm0MyF1JEIyx4Yjj94-UbHkPdtw6JllnTrIUsfOWktTx2MCmzHe2vnA9jkx6iEASy57lwpd__f0EUQiEjXPQWNYrdgVOjeUmwnRFsrGuyvKlZ87KW54kGOsavM4Qpl48utFNxQE4ItV87Hqbu6iHQX_Ku8I57T_31Oi0b_puKoNRTppG9rrFf5firc3r_xwUKC27dfey6F5rXNNJJjHXaaHZVbkq55iPuZgEfHxBdkc8j9y_LsrulbbLVSMT6cxPqgWszGPxA'
  })
}

const loginOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': 'Basic Y3JtQ2xpZW50MTpjcm1TdXBlclNlY3JldA=='
  })
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseUrl = apiEndPoint;

  constructor(private http: HttpClient) { }

  public getAll<T>(url: string, op: string = ''): Observable<T[]> {
    return this.http.get<T[]>(this.baseUrl + url)
      .pipe(
        catchError(this.handleError(op, []))
      );
  }

  public get<T>(url: string, op: string = ''): Observable< any | T> {
    return this.http.get<T>(this.baseUrl + url)
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

    const httpParams = new HttpParams()
      .append('username', user.username)
      .append('password', user.password)
      .append('grant_type', user.grant_type);
    console.log(loginOptions);
    return this.http.post(this.baseUrl + '/oauth/token', httpParams, loginOptions)
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
