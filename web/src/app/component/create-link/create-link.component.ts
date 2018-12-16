import { Component, OnInit } from '@angular/core';
import {LinksModel} from "../../models/links.model";
import {HttpService} from "../../services/http.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-create-link',
  templateUrl: './create-link.component.html',
  styleUrls: ['./create-link.component.css']
})
export class CreateLinkComponent implements OnInit {

  link: LinksModel = new LinksModel();

  constructor(private http: HttpService, private router: Router) { }

  ngOnInit() {
  }

  add(): void {
    console.log(this.link);
    this.http.postAsJson('/api/users/addLink', this.link).subscribe(() => {
      console.log('Added.');
      this.router.navigate(['/component/links']);
    });
  }

}
