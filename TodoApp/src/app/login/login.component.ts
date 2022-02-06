import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { AUTHENTICATED_USER, BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService, private basicAuthService: BasicAuthenticationService) { }
  username: string;
  password: string;
  errorMessage: string = 'Invalid credentials..!!!';
  invalidLogin: boolean = false;

  ngOnInit() {
  }

  handleBasicAuthLogin(){
    console.log(this.username);
    this.basicAuthService.login(this.username, this.password).subscribe(loginResp => {
      console.log('--loginResp--', loginResp);
      if(loginResp.statusCode == 'FORBIDDEN') {
        this.invalidLogin = true;
      } else {
        this.invalidLogin = false;
        sessionStorage.setItem(AUTHENTICATED_USER, loginResp.userId);
        this.router.navigate(['./todos']);
      }
    }, errorLoginResp => {
      console.log('--errorLoginResp--', errorLoginResp);
      this.invalidLogin = true;
    });
  }

}
