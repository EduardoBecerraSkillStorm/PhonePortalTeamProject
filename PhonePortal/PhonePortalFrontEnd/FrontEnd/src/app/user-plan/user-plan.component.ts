import { Component, OnInit } from '@angular/core';
import { UserPlan } from '../models/userplan.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-plan',
  templateUrl: './user-plan.component.html',
  styleUrls: ['./user-plan.component.css']
})
export class UserPlanComponent implements OnInit {
  UserPlan: UserPlan[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe((data) => {
      if(data.body != null) {
        this.UserPlan = data.body;
        console.log("Body: " + this.UserPlan);
      }
    });
  }

  growTable(){
    let temp1: UserPlan = new UserPlan('Dan Pickles', 'Standard', 'Samsung', 123456789);
    let temp2: UserPlan = new UserPlan('Eduardo', 'Ultimate', 'Iphone', 999999999);
    let temp3: UserPlan = new UserPlan('Dariel', 'Standard', 'Iphone', 543543543);

    this.UserPlan.push(temp1);
    this.UserPlan.push(temp2);
    this.UserPlan.push(temp3);
  }

  reverseTable(){
    this.UserPlan.reverse();
  }

}
