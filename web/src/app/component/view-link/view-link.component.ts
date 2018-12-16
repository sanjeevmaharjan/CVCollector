import { Component, OnInit } from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {HttpService} from '../../services/http.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-view-link',
  templateUrl: '../cv-grid/cv-grid.component.html',
  styleUrls: ['../cv-grid/cv-grid.component.css']
})
export class ViewLinkComponent implements OnInit {
  cvs: CvModel[];

  constructor(private httpService: HttpService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.httpService.get('/api/users/getLinksCv/' + id).subscribe(val => {
      this.cvs = val;
    });
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
