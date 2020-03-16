import { LoginInfo } from './../models/login-info';
import { Observable } from 'rxjs';
import { User } from './../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private _registerUrl = 'http://localhost:8080/api/auth/register';
  private _connexionUrl = 'http://localhost:8080/api/auth/authenticate';

  constructor(private _httpClient: HttpClient) { }

  register(user: User): Observable<User> {
    return this._httpClient.post<User>(this._registerUrl, user);
  }

  authenticate(credentials: LoginInfo): Observable<string> {
    return this._httpClient.post<string>(this._connexionUrl, credentials);
  }
}
