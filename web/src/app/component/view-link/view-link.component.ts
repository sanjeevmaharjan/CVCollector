import { Component, OnInit } from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {HttpService} from '../../services/http.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PageCvModel} from "../../models/page-cv.model";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-view-link',
  templateUrl: '../cv-grid/cv-grid.component.html',
  styleUrls: ['../cv-grid/cv-grid.component.css']
})
export class ViewLinkComponent implements OnInit {
  cvs: CvModel[];
  id: number;

  isFirst: boolean;
  isLast: boolean;

  size: number;
  page: number = 1;

  constructor(private httpService: HttpService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.httpService.get<PageCvModel>('/api/users/getLinksCv/' + this.id + '?page=0')
      .subscribe(
        cvs => {
          this.cvs = cvs.content;
          this.size = cvs.totalPages;
          if (!environment.production) {
            console.log(cvs);
          }
        }
      );
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

  getPage(n: number) {
    this.httpService.get<PageCvModel>('/api/users/getLinksCv/' + this.id + '?page=' + (n - 1))
      .subscribe(
        cvs => {
          this.cvs = cvs.content;
          this.size = cvs.totalPages;
          if (!environment.production) {
            console.log(cvs);
          }
        }
      );
  }

  open(k: number) {
    this.router.navigate(['/component/cv/' + k]);
  }

}
