import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductComponent } from './product/product.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path:"" , component:HomeComponent},
  {path:"header" , component:HeaderComponent},
  {path:"customer" , component:CustomerComponent},
  {path:"product" , component:ProductComponent},
  {path:"login" , component:LoginComponent},
];

@ NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
