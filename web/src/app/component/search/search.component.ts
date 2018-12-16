import {Component, OnInit} from '@angular/core';
import {SearchModel} from '../../models/search.model';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  search: SearchModel = new SearchModel();

  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
  }

  getSearch(event): void {
    console.log(this.search);
    this.httpService.postAsJson<SearchModel>('/api/cv/filter/criteria', this.search)
      .subscribe(result => {
        console.log(result);
      });
    event.preventDefault();
  }

}
