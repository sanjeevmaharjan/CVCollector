import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';
import { apiEndPoint } from '../../environments/environment';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/internal/observable/of';
import {LoginModel} from '../models/login.model';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

const authOptions = {
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

  postAsJson<T>(url: string, body: T, op: string = '') {
    return this.http.post<T>(this.baseUrl + url, body, httpOptions)
      .pipe(
        catchError(this.handleError(op, body))
      );
  }

  public login(user: LoginModel): Observable<any> {
    console.log(authOptions);
    const body = this.convertJsonToUrlEncoded(user);
    return this.http.post(this.baseUrl + '/oauth/token', body, authOptions)
      .pipe(
        catchError(this.handleError('login', body))
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

  private convertJsonToUrlEncoded(json: any) {
    const params = [];

    for (const key in json) {
      if (json.hasOwnProperty(key)) {
        params.push(encodeURIComponent(key) + '=' + encodeURIComponent(json[key]));
      }
    }

    return params.join('&');
  }
}
