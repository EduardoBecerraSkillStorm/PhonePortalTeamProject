import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChooseYourPlanComponent } from './choose-your-plan/choose-your-plan.component';
import { HomePageComponent } from './home-page/home-page.component';
import { PlanSpecificationsPageComponent } from './plan-specifications-page/plan-specifications-page.component';
import { UserPlanComponent } from './user-plan/user-plan.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './helpers/auth-guard';

const routes: Routes = [
  { path: 'account', component: UserPlanComponent, canActivate: [AuthGuard]  },
  { path: 'chooseyourplan', component: ChooseYourPlanComponent },
  { path: 'planspecificationspage', component: PlanSpecificationsPageComponent, canActivate: [AuthGuard] },
  { path: 'home', component: HomePageComponent },
  { path: 'login', component: LoginComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
