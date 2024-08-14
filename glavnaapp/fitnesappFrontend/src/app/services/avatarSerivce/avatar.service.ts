import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Avatar } from 'src/app/interface/Avatar/Avatar';
import { User } from 'src/app/interface/User/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AvatarService {

  constructor(private http: HttpClient) { }
  
  url = environment.apiUrl;
  
  public addAvatar(avatarItem: Avatar): Observable<Avatar> {

    return this.http.post<Avatar>(this.url + "/userAvatar", avatarItem, {headers: environment.headerOption});
  }

}
