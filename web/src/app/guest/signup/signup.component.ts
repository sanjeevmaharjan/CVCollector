import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  company: string;
  username: string;
  password: string;
  email: string;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  register() {
    this.router.navigate(['login']).then(ok => {
      console.log(ok);
    });
  }

}
