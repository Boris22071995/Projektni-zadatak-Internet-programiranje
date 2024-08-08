import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from 'src/app/interface/User/User';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  url = environment.apiUrl;

  public addUser(userItem: User): Observable<User> {
    return this.http.post<User>(this.url + "/user",userItem);
  }
}
