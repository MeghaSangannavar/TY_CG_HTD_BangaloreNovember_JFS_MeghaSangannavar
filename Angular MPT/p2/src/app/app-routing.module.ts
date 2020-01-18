import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PostsComponent } from './posts/posts.component';
import { AddpostsComponent } from './addposts/addposts.component';
import { HeaderComponent } from './header/header.component';


const routes: Routes = [
  {path:"" , component:HomeComponent},
  {path:"posts" , component:PostsComponent},
  {path:"addposts" , component:AddpostsComponent},
  {path:"header" , component:HeaderComponent}
];

@ NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
