import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ListAppuntamentiComponent } from './list-appuntamenti/list-appuntamenti.component';
import { AddAppuntamentoComponent } from './add-appuntamento/add-appuntamento.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { httpInterceptorProviders } from './helpers/auth.interceptor';
import { DatePipe } from '@angular/common';
import { EditAppuntamentoComponent } from './edit-appuntamento/edit-appuntamento.component';

@NgModule({
  declarations: [
    AppComponent,
    ListAppuntamentiComponent,
    AddAppuntamentoComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    EditAppuntamentoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    httpInterceptorProviders,
    DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule { }
