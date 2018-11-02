import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanActivateChild } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class UserAuthGuard implements CanActivateChild {
    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
        if (this.auth.getToken()) {
            return true;
        }

        localStorage.setItem('returnUrl', state.url);

        console.log('navigate to login');
        this.router.navigate(['/login']);

        return false;
    }

    constructor(private router: Router, private auth: AuthService) { }

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Observable<boolean> | Promise<boolean> | boolean {
        if (this.auth.getToken()) {
            return true;
        }

        localStorage.setItem('returnUrl', state.url);

        console.log('navigate to login');
        this.router.navigate(['/login']);

        return false;
    }
}
