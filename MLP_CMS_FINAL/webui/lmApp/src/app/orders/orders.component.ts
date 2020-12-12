import { Component, OnInit } from '@angular/core';
import { OrdersService } from './orders.service';
import { orders } from './orders';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  OrdersDetails:orders[];

  constructor(private Ordersservice:OrdersService) { }
  
  orderId:number;
  customerId:number;
  vendorId:number;
  orderStatus:string;
  Order:orders[];
  data:string;



  ngOnInit(): void {
    this.Ordersservice.httpOrdersFetch().subscribe((data)=>this.OrdersDetails=data);

    
      }

  orderFun(orderForm){
    this.orderId=orderForm.value.orderId;
    this.customerId=orderForm.value.customerId;
    this.vendorId=orderForm.value.vendorId;
    this.orderStatus=orderForm.value.orderStatus;
    this.Ordersservice.httpAcceptOrReject(this.orderId,this.customerId,this.vendorId,this.orderStatus).subscribe((value)=>this.data=value);
    this.Ordersservice.httpOrdersFetch().subscribe((data)=>this.OrdersDetails=data);
  }

}
