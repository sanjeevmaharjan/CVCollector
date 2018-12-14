import {Injectable} from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse, HttpErrorResponse
} from '@angular/common/http';
import {AuthService} from './auth.service';
import {ToastrService} from 'ngx-toastr';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(public auth: AuthService, private toastr: ToastrService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {

    return next.handle(req)
      .do((event: HttpEvent<any>) => {
        if (event instanceof HttpResponse) {
          // TODO do stuff with response if you want
        }
      }, (err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401) {
            this.toastr.error('Please login to continue.');
            this.auth.logout();
            location.reload(true);
          }
        }
      });
  }
}
