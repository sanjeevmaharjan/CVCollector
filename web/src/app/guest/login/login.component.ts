import { Component, OnInit } from '@angular/core';
import {LoginModel} from '../../models/login.model';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private authService: AuthService) {
    this.username = 'sanjeev'; // TODO make empty
    this.password = 'Admin'; // TODO make empty
  }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.username, this.password);
  }

}
