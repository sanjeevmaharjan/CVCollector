import {CvComponent} from './cv/cv.component';


export const clientRoutes = [
  {
    path: '',
    component: CvComponent,
    data: {
      title: 'CV',
      urls: [{title: 'Dashboard', url: '/dashboard'},
      {title: 'CV'}]
    }
  }
];
