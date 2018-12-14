import {Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {CvComponent} from "./cv/cv.component";
import {PreviewComponent} from "./preview/preview.component";
import {HomeComponent} from "./home/home.component";

export const GuestRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'home',
        component: HomeComponent,
        data: {
          title: 'Home',
          urls: [
            {title: 'Home', url: '/home'}
          ]
        }
      },
      {
        path: 'login',
        component: LoginComponent,
        data: {
          title: 'Login',
          urls: [
            {title: 'Home', url: '/home'},
            {title: 'Login'}
          ]
        }
      },
      {
        path: 'cv/:client',
        component: CvComponent,
        data: {
          title: 'Cv',
          urls: [
            {title: 'Home', url: '/home'},
            {title: 'Cv'}
          ]
        }
      },
      {
        path: 'preview',
        component: PreviewComponent,
        data: {
          title: 'Cv Preview',
          urls: [
            {title: 'Home', url: '/home'},
            {title: 'Cv', url: '/cv'},
            {title: 'Preview'}
          ]
        }
      }
    ]
  }
];
