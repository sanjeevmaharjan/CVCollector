import { Component, OnInit } from '@angular/core';
import {CvModel} from '../../models/cv/cv.model';
import {ActivatedRoute} from '@angular/router';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-cv-individual',
  templateUrl: './cv-individual.component.html',
  styleUrls: ['./cv-individual.component.css']
})
export class CvIndividualComponent implements OnInit {
  cv: CvModel;

  constructor(private route: ActivatedRoute, private httpService: HttpService) {
    const id = this.route.snapshot.params['id'];

    this.httpService.get<CvModel>('/api/cv/' + id).subscribe(cv => {
      this.cv = cv;
      console.log(cv);
    });
  }

  ngOnInit() {
  }

}
