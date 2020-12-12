import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { orders } from './orders';


@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  

  constructor(private http:HttpClient) { }
  httpOrdersFetch():Observable<orders[]>{
    return this.http.get<orders[]>("http://localhost:8080/MLPXX-0.0.1-SNAPSHOT/api/acceptReject/showOrders");
  }
   httpAcceptOrReject(orderId,customerId,vendorId,orderStatus):Observable<string>{
    return this.http.post<string>("http://localhost:8080/MLPXX-0.0.1-SNAPSHOT/api/acceptReject/updatestatus/"+orderId+"/"+customerId+"/"+vendorId+"/"+orderStatus,{});
  
  }

 
  


}
