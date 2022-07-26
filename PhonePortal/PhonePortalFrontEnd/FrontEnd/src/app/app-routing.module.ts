import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChooseYourPlanComponent } from './choose-your-plan/choose-your-plan.component';
import { HomePageComponent } from './home-page/home-page.component';
import { PlanSpecificationsPageComponent } from './plan-specifications-page/plan-specifications-page.component';
import { AccountComponent } from './account/account.component';
import { LoginComponent } from './login/login.component';
//import { LoginComponent } from './unused/login/login.component';
//import { AuthGuard } from './unused/helpers/auth-guard';

const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'account', component: AccountComponent, /*canActivate: [AuthGuard] */},
  { path: 'chooseyourplan', component: ChooseYourPlanComponent },
  { path: 'planspecificationspage', component: PlanSpecificationsPageComponent, /*canActivate: [AuthGuard]*/ },
  { path: 'skillstormlogin', component: LoginComponent }

  //{ path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
