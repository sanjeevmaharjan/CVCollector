import { Component, OnInit } from '@angular/core';
import {NgbTabChangeEvent} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  public beforeChange($event: NgbTabChangeEvent) {
    if ($event.nextId === 'tab-preventchange2') {
      $event.preventDefault();
    }
  };
}
