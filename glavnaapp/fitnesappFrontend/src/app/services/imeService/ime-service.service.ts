import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Category } from 'src/app/interface/Category/Category';
import {Observable} from 'rxjs'
@Injectable({
  providedIn: 'root'
})
export class ImeServiceService {

  constructor(private http: HttpClient) { }
  
  url = environment.apiUrl;

  public addCategory(categoryItem: Category): Observable<Category> {
    return this.http.post<Category>(this.url + "/category", categoryItem);
  }
}
