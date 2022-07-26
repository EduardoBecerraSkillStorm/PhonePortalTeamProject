import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountComponent } from './account/account.component';
import { ChooseYourPlanComponent } from './choose-your-plan/choose-your-plan.component';
import { PlanSpecificationsPageComponent } from './plan-specifications-page/plan-specifications-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
//import { LoginComponent } from './unused/login/login.component';
//import { JwtInterceptor } from './unused/helpers/jwt.interceptor';
//import { ErrorInterceptor } from './unused/helpers/error.interceptor';
//import { AuthGuard } from './unused/helpers/auth-guard';

@NgModule({
  declarations: [
    //LoginComponent,
    AppComponent,
    AccountComponent,
    ChooseYourPlanComponent,
    PlanSpecificationsPageComponent,
    HomePageComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  exports: [
    ReactiveFormsModule
  ],
  providers: [
 /*   { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  */
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
