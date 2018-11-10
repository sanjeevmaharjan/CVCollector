export class LoginModel {
  username: string;
  password: string;
  grant_type: string;


  constructor(username: string, password: string, grant_type: string) {
    this.username = username;
    this.password = password;
    this.grant_type = grant_type;
  }
}
