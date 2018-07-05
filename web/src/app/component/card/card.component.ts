import { Component} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
	templateUrl: 'card.component.html'
})
export class CardsComponent {
  private baseUrl = 'http://localhost:8080';
  private cvUrl = '/cv';
	constructor(
	  private http: HttpClient
  ) {
    this.http.get(this.baseUrl + this.cvUrl);
  }
}
