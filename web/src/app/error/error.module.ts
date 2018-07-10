import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ErrorComponent} from "./error.component";
import {RouterModule} from "@angular/router";
import {ErrorRoutes} from "./error.routing";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ErrorRoutes),
    NgbModule
  ],
  declarations: [ErrorComponent]
})
export class ErrorModule { }
