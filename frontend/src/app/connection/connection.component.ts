import { Router } from '@angular/router';
import { HeaderService } from './../services/header.service';
import { TokenStorageService } from './../services/token-storage.service';
import { LoginInfo } from './../models/login-info';
import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.sass']
})
export class ConnectionComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private _formBuilder: FormBuilder,
    private _auth: AuthenticationService,
    private _token: TokenStorageService,
    private _header: HeaderService,
    private _router: Router) {
  }


  ngOnInit(): void {
    this.loginForm = this._formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  login() {
    if (this.loginForm.invalid) {
      console.log('invalid form');
      return;
    }
    console.log(this.loginForm.value);
    const loginInfo: LoginInfo = new LoginInfo();
    loginInfo.email = this.loginForm.value.email;
    loginInfo.password = this.loginForm.value.password;
    this._auth.authenticate(loginInfo).subscribe(data => {
      this._token.saveToken(data);
      this._header.refreshNavBar(true);
      this._router.navigate(['/home']);
    });
  }
}
