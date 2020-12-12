import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { HttpClientModule } from '@angular/common/http';
import { AcceptrejectComponent } from './acceptreject/acceptreject.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderComponent } from './orders/orders/order.component';
const route:Routes=[
  {path:"",redirectTo:"menu",pathMatch:"full"},
  {path:"menu",component:MenuComponent},
  {path:"accrej",component:AcceptrejectComponent},
  {path:"ord",component:OrdersComponent},
  
]

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AcceptrejectComponent,
    OrdersComponent,
    OrderComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(route),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
