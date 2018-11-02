import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CvComponent } from './cv/cv.component';
import {GuestRoutes} from './guest.routing';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {TextDirective} from '../shared/form-elements/text.directive';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PreviewComponent} from './preview/preview.component';
import {HomeComponent} from './home/home.component';
import {CvViewComponent} from '../shared/cv-view/cv-view.component';
import {AgmCoreModule} from '@agm/core';
import {Browser} from 'selenium-webdriver';
import {BrowserModule} from '@angular/platform-browser';
import {MapComponent} from './cv/map/map.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(GuestRoutes),
    NgbModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDqpY69EhXQPO9VA6MtuZy_hmvSN2OY7a4',
      apiVersion: '3.33'
    })
  ],
  declarations: [
    LoginComponent,
    SignupComponent,
    TextDirective,
    PreviewComponent,
    HomeComponent,
    CvComponent,
    MapComponent
  ]
})
export class GuestModule { }
