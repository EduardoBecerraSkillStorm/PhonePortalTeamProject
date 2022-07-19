import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChooseYourPlanComponent } from './choose-your-plan/choose-your-plan.component';
import { PlanSpecificationsPageComponent } from './plan-specifications-page/plan-specifications-page.component';
import { UserPlanComponent } from './user-plan/user-plan.component';

const routes: Routes = [
  {
    path: 'account', component: UserPlanComponent
  },
  {
    path: 'chooseyourplan', component: ChooseYourPlanComponent
  },
  {
    path: 'planspecificationspage', component: PlanSpecificationsPageComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
