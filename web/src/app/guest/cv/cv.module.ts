import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import {AgmCoreModule} from "@agm/core";
import {CvComponent} from "./cv.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    /*AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDqpY69EhXQPO9VA6MtuZy_hmvSN2OY7a4',
      libraries: ['places']
    }),*/
    NgbModule,
    FormsModule
  ],
  declarations: [CvComponent]
})
export class CvModule { }
