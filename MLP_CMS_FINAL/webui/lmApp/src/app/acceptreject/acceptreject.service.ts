import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {acceptreject} from  './acceptreject';


@Injectable({
  providedIn: 'root'
})
export class AcceptrejectService {

  constructor(private http : HttpClient) { }
  showOrderFun():Observable<acceptreject[]>{
    return this.http.get<acceptreject[]>("http://localhost:8080/MLPXX-0.0.1-SNAPSHOT/api/acceptReject/showOrders");


  }
  
  
}





