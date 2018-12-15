import { Component, OnInit } from '@angular/core';
import {SearchModel} from "../../models/search.model";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  search: SearchModel = new SearchModel();

  constructor() { }

  ngOnInit() {
  }

}
