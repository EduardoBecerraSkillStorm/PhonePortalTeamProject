import { Component, OnInit } from '@angular/core';
import { Plan } from '../unused/plan.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-choose-your-plan',
  templateUrl: './choose-your-plan.component.html',
  styleUrls: ['./choose-your-plan.component.css']
})
export class ChooseYourPlanComponent implements OnInit {
  newPlan?: Plan;  //? tell TS that the value can be undefined

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  createPlan(): void {

  }

}
