import {Component, OnInit} from '@angular/core';
import {SearchModel} from '../../models/search.model';
import {HttpService} from '../../services/http.service';
import {CvModel} from "../../models/cv/cv.model";
import {PageCvModel} from "../../models/page-cv.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  search: SearchModel = new SearchModel();
  cvs: CvModel[];

  isFirst: boolean;
  isLast: boolean;

  size = 10;
  page = 1;

  constructor(private httpService: HttpService, private router: Router) {
  }

  ngOnInit() {
  }

  getSearch(event): void {
    console.log(this.search);
    this.httpService.postAsJson<SearchModel>('/api/cv/filter/criteria', this.search)
      .subscribe(result => {
        this.cvs = result.content;

        this.page = result.pageable.pageNumber;
        this.size = result.totalPages;

        console.log(result);
      });
    event.preventDefault();
  }

  getGender(id: number): string {
    switch (id) {
      case 0:
        return 'Unspecified';
      case 1:
        return 'Male';
      case 2:
        return 'Female';
      default:
        return 'Unspecified';
    }
  }

  open(k: number) {
    this.router.navigate(['/component/cv/' + k]);
  }

}
