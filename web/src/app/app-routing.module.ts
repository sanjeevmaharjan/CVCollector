import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FullComponent } from './layouts/full/full.component';
import {FrontComponent} from './layouts/front/front.component';
import {ErrorComponent} from './error/error.component';
import { UserAuthGuard } from './auth/user.auth.guard';

export const Approutes: Routes = [
/*
* Match for the root for frontend
* */
{
  path: '',
  component: FrontComponent,
  children: [
    { path: '', loadChildren: './guest/guest.module#GuestModule' },
    { path: 'error', loadChildren: './error/error.module#ErrorModule'}
  ]
},

  /*
  * Match for the root for backend
  * */
{
    path: '',
    component: FullComponent,
    children: [
        // { path: '', redirectTo: '/starter', pathMatch: 'full' },
        { path: 'starter', loadChildren: './starter/starter.module#StarterModule', canActivateChild: [UserAuthGuard] },
      { path: 'component', loadChildren: './component/component.module#ComponentsModule', canActivateChild: [UserAuthGuard] }
    ]
},

  /*
  * Everything else
  * */
{
    path: '**',
    redirectTo: '/error'
}];


