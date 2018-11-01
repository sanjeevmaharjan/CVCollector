import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../services/http.service";
import {LoginModel} from "../../models/cv/login.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private httpService: HttpService) {
    this.username = "sanjeev"; // TODO make empty
    this.password = "Admin"; // TODO make empty
  }

  ngOnInit() {
  }

  login() {
    let user = new LoginModel(this.username, this.password, 'password')

    this.httpService.login(user).subscribe(data =>
      console.log(data)
    );
  }

}
