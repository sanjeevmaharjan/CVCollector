import {Injectable} from '@angular/core';
import {HttpService} from '../services/http.service';
import {LoginModel} from '../models/login.model';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpService: HttpService, private router: Router) {
  }

  public static tokenNotExpired(obj, token): boolean {
    return true;
  }

  public getToken(): string {
    const user = JSON.parse(localStorage.getItem('currentUser'));
    return user ? user.access_token : null;
  }

  public getUser(): string {
    const user = JSON.parse(localStorage.getItem('currentUser'));
    const jwt = user ? user.access_token : null;
    if (jwt) {
      const jwtData = user.access_token.split('.')[1];
      const decodedJwtJsonData = window.atob(jwtData);
      const decodedJwtObject = JSON.parse(decodedJwtJsonData);
      console.log(decodedJwtObject);
      return decodedJwtObject.user_name;
    }
  }

  public isAuthenticated(): boolean {
    // get the token
    const token = this.getToken();

    //
    return AuthService.tokenNotExpired(null, token);
  }

  public login(username: string, password: string) {
    const observableLogin = this.httpService.login(
      new LoginModel(
        username,
        password,
        'password'
      )
    );

    observableLogin.subscribe(response => {
        if (response && response.access_token) {
          localStorage.setItem('currentUser', JSON.stringify(response));

          const returnUrl = localStorage.getItem('returnUrl');
          localStorage.removeItem('returnUrl');
          const goto = returnUrl ? returnUrl : '/home';

          this.router.navigate([goto]);
        }
      },
      error => {
        console.error(error);
      });
  }

  public logout() {

    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }
}
