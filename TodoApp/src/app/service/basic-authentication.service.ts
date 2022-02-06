import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { API_URL } from '../app.constants';

export class AuthenticationBean {
  constructor(public message: string) {}
}

export const AUTHENTICATED_USER = 'authenticatedUser';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {
  constructor(private http: HttpClient) { }

  login(userName: string, password: string) {
    return this.http.post<any>(`${API_URL}/user/login`, {
      userName,
      password
    }).pipe(
      map(data => {
        return data;
      })
    );
  }

  getAuthenticatedUser(){
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }
  
  getAuthenticatedToken(){
    if(this.getAuthenticatedUser())
      return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return !(user === null);
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER);
  }

}
