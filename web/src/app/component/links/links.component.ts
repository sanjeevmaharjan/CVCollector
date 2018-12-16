import { Component, OnInit } from '@angular/core';
import {LinksModel} from '../../models/links.model';
import {HttpService} from "../../services/http.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-links',
  templateUrl: './links.component.html',
  styleUrls: ['./links.component.css']
})
export class LinksComponent implements OnInit {
  links: LinksModel[];

  constructor(private httpService: HttpService, private router: Router) { }

  ngOnInit() {
    this.httpService.get('/api/users/getLinks').subscribe(val => {
      this.links = val;
    });
  }

  viewLink(id: number) {
    this.router.navigate(['/component/viewLink/' + id]);
  }

}
