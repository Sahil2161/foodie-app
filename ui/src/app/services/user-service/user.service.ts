import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { User } from 'src/models/User.model';
import { UserAuth } from 'src/models/UserAuth.model';
import { Userfp } from 'src/models/Userfp.model';
import { Userrp } from 'src/models/Userrp.model';

@Injectable({ providedIn: 'root' })
export class UserService {

  public currentUser!: User;

  private BASE_URL: string = 'http://localhost:2323';

  constructor(private http: HttpClient) { }
  
  getCurrentUser(): User {
    return this.currentUser;
  }

  saveUser(user: User) {
    console.log('sign up attempt: ', user)
    return this.http.post<User>(this.BASE_URL + "/user/register", user);
  }

  login(user: UserAuth) {
    console.log('login attempt: ', user);
    return this.http.post<User>(this.BASE_URL + "/user/login", user);
  }

  forgotPassword(user: Userfp): Observable<Userfp> {
    return this.http.post<Userfp>(this.BASE_URL + "/forgot/change", user);
  }

  resetPassword(user: Userrp): Observable<Userrp> {
    return this.http.post<Userrp>(this.BASE_URL + "/forgot/reset", user);
  }
}

