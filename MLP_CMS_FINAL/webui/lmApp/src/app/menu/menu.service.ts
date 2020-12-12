import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {menu} from './Menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http:HttpClient) { }
  httpMenuFetch():Observable<menu[]>{
    return this.http.get<menu[]>("http://localhost:8080/MLPXX-0.0.1-SNAPSHOT/api/menu/menuList")

  }
}
