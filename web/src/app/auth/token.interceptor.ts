import { Injectable } from '@angular/core';
import {
    HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    constructor(public auth: AuthService) {}

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        const currentToken = this.auth.getToken();

        if (currentToken) {
            console.log('Attaching Header for ' + this.auth.getUser());
            req = req.clone({
                setHeaders: {
                    Authorization: `Bearer ${currentToken}`
                }
            });
        }

        return next.handle(req);
    }
}
