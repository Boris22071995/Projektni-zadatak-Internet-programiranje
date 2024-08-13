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
  
  public getUser() {
    return this.http.get(this.url + "/user/userName");
  }

  public async temp() :Promise<any> {
    var pageNr = await this.getUser().toPromise();
    return pageNr;
  }

  public addAvatar(avatarItem: Avatar): Observable<Avatar> {
    avatarItem.useridUser=1;
    return this.http.post<Avatar>(this.url + "/userAvatar", avatarItem);
  }

}
