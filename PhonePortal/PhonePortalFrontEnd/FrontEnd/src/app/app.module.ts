import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserPlanComponent } from './user-plan/user-plan.component';
import { ChooseYourPlanComponent } from './choose-your-plan/choose-your-plan.component';
import { PlanSpecificationsPageComponent } from './plan-specifications-page/plan-specifications-page.component';

@NgModule({
  declarations: [
    AppComponent,
    UserPlanComponent,
    ChooseYourPlanComponent,
    PlanSpecificationsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
