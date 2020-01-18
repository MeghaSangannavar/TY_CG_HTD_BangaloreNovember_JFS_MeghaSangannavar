import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { AddpostsComponent } from './addposts/addposts.component';
import { PostsComponent } from './posts/posts.component';

@ NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    AddpostsComponent,
    PostsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
