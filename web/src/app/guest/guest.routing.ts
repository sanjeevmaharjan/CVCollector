import {Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {CvComponent} from "./cv/cv.component";

export const GuestRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'login',
        component: LoginComponent,
        data: {
          title: 'Login',
          urls: [{title: 'Home'}]
        }
      },
      {
        path: 'cv',
        component: CvComponent,
        data: {

        }
      }
    ]
  }
];
