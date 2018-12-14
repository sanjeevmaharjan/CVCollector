import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  numCvs = '...';
  numCvsToday = '...';
  numCvsThisWeek = '...';

  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.httpService.get<any>('/api/dashboard').subscribe(data => {
      this.numCvs = data.numCvs;
      this.numCvsToday = data.submittedToday;
      this.numCvsThisWeek = data.submittedThisWeek;
    });
  }

}
