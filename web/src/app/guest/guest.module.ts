import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CvComponent } from './cv/cv.component';
import {GuestRoutes} from "./guest.routing";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(GuestRoutes),
    NgbModule
  ],
  declarations: [LoginComponent, SignupComponent, CvComponent]
})
export class GuestModule { }
