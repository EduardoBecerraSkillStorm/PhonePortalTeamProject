import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { UserService } from '../services/user.service';
import {LoginComponent} from '../login/login.component';
import { PersistanceService } from '../services/persistence.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-plan',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  thisUser: User = new User ("","","","", 0,"","","","","","","",0);
  userPlan: string = "";
  device: string = "";
  device2: string = "";
  device3: string = "";
  device4: string = "";
  phoneNumber: string = "";
  phoneNumber2: string = "";
  phoneNumber3: string = "";
  phoneNumber4: string = "";
  activateFamilyPlan: boolean = false;
  activateFamilyPlan2: boolean = false;
  activateFamilyPlan3: boolean = false;
  activateFamilyPlan4: boolean = false;
  familyPlanAmount: string = "";
  activateFamilyCount: boolean = false;
  monthlyBill: number = 0;
  ultimatePlanPrice: number = 55;
  standardPlanPrice: number = 35;
  familyPlan2Price: number = 60;
  familyPlan3Price: number = 90;
  familyPlan4Price: number = 120;
  devicesTitle2: boolean = false;
  devicesTitle3: boolean = false;
  devicesTitle4: boolean = false;
  activateFamilyPlanComponent: boolean = false;
  activateDevices: boolean = false;
  activatePhoneNumber: boolean = false;

  constructor(private userService: UserService,
              private router: Router,
              private persister: PersistanceService
   // private loginComponent: LoginComponent 
    ) { }
 
    ngOnInit(): void {
      const currentUser = this.persister.get('currentUser');
      console.log("this is currentUser: " + JSON.stringify(currentUser));
      this.thisUser = new User (currentUser.device_name_1, currentUser.device_name_2, currentUser.device_name_3,currentUser.device_name_4,currentUser.monthly_price,currentUser.name,currentUser.pass_word,currentUser.phone_number_1,currentUser.phone_number_2,currentUser.phone_number_3,currentUser.phone_number_4,currentUser.plan_name,currentUser.user_id);
    }


      updateUserPlan(): void {
        console.log(this.familyPlanAmount);
        this.thisUser.plan_name= this.userPlan;
        if (this.thisUser.plan_name === "Standard")  {
          this.thisUser.monthly_price = this.standardPlanPrice;
          this.thisUser.device_name_2 = "";
          this.thisUser.device_name_3 = "";
          this.thisUser.device_name_4 = "";
          this.thisUser.phone_number_2 = "";
          this.thisUser.phone_number_3 = "";
          this.thisUser.phone_number_4 = "";
          this.devicesTitle2 = false;
          this.devicesTitle3 = false;
          this.devicesTitle4 = false;
          this.activateFamilyCount = false;
          this.activateDevices = true;
          this.activatePhoneNumber = true;
          this.activateFamilyPlanComponent = false;
        }
        else if (this.thisUser.plan_name === "Ultimate") {
          this.activateDevices = true;
          this.thisUser.monthly_price = this.ultimatePlanPrice;
          this.thisUser.device_name_2 = "";
          this.thisUser.device_name_3 = "";
          this.thisUser.device_name_4 = "";
          this.thisUser.phone_number_2 = "";
          this.thisUser.phone_number_3 = "";
          this.thisUser.phone_number_4 = "";
          this.devicesTitle2 = false;
          this.devicesTitle3 = false;
          this.devicesTitle4 = false;
          this.activateFamilyCount = false;
          this.activateDevices = true;
          this.activatePhoneNumber = true;
          this.activateFamilyPlanComponent = false;
        }
        else if (this.thisUser.plan_name === "FamilyPlan") {
          this.activateFamilyCount = true;
                  this.activateDevices = false;
        this.activatePhoneNumber = false;
        }
        console.log("plan updated: " + JSON.stringify(this.thisUser));

        const currentUser = this.persister.get('currentUser');
        this.userService.updateUser(currentUser, this.thisUser).subscribe(updatedUser => {
          this.persister.set('currentUser', updatedUser );
          let route = this.router.config.find(r => r.path === 'account');
          if (route) {
            this.router.navigateByUrl('/account');
           }
        })
      }

      familyPlanAccount(): void {
        this.familyPlanAmount;
        this.activateFamilyPlanComponent = true;
        if (this.familyPlanAmount === "2" ) {
          this.activateFamilyPlan = true;
          this.activateFamilyPlan2 = true;
          this.thisUser.monthly_price = this.familyPlan2Price;
          this.devicesTitle2 = true;
        }
        else if (this.familyPlanAmount === "3" ) {
          this.activateFamilyPlan = true;
          this.activateFamilyPlan2 = true;
          this.activateFamilyPlan3 = true;
          this.thisUser.monthly_price = this.familyPlan3Price;
          this.devicesTitle2 = true;
          this.devicesTitle3 = true;
        }
        else if (this.familyPlanAmount === "4" ) {
        this.activateFamilyPlan = true;
        this.activateFamilyPlan2 = true;
        this.activateFamilyPlan3 = true;
        this.activateFamilyPlan4 = true;
        this.thisUser.monthly_price = this.familyPlan4Price;
        this.devicesTitle2 = true;
        this.devicesTitle3 = true;
        this.devicesTitle4 = true;
        }
      }


      updateDevice(): void {
        this.thisUser.device_name_1 = this.device;
        console.log("device updated: " + JSON.stringify(this.thisUser));
        console.log(this.device);

        const currentUser = this.persister.get('currentUser');
        this.userService.updateUser(currentUser, this.thisUser).subscribe(updatedUser => {
          this.persister.set('currentUser', updatedUser );
          let route = this.router.config.find(r => r.path === 'account');
          if (route) {
            this.router.navigateByUrl('/account');
           }
        })

      }

      updatePhoneNumber(): void {
        this.thisUser.phone_number_1 = this.phoneNumber;
        console.log("device updated: " + JSON.stringify(this.thisUser));
        console.log(this.thisUser.phone_number_1);

        const currentUser = this.persister.get('currentUser');
        this.userService.updateUser(currentUser, this.thisUser).subscribe(updatedUser => {
          this.persister.set('currentUser', updatedUser );
          let route = this.router.config.find(r => r.path === 'account');
          if (route) {
            this.router.navigateByUrl('/account');
           }
        })
      }
      
      updateFamilyPlan(): void {
        this.thisUser.device_name_1 = this.device; 
        this.thisUser.device_name_2 = this.device2;
        this.thisUser.device_name_3 = this.device3;
        this.thisUser.device_name_4 = this.device4;
        this.thisUser.phone_number_1 = this.phoneNumber;
        this.thisUser.phone_number_2 = this.phoneNumber2;
        this.thisUser.phone_number_3 = this.phoneNumber3;
        this.thisUser.phone_number_4 = this.phoneNumber4;
        console.log("user updated: " + JSON.stringify(this.thisUser));

        const currentUser = this.persister.get('currentUser');
        this.userService.updateUser(currentUser, this.thisUser).subscribe(updatedUser => {
          this.persister.set('currentUser', updatedUser );
          let route = this.router.config.find(r => r.path === 'account');
          if (route) {
            this.router.navigateByUrl('/account');
           }
        })
      }













      
      /*
      this.userService.findbyid(currentUser).subscribe((matchingUser) => {
        user = matchingUser;
        if(user.body != null) {
          matchingUser = user.body;
          console.log("Body: " + matchingUser);
         // console.log(this.loginComponent.Login.name)


        }
      })
      */
}



/*
  ngOnInit(): void {
    this.userService.findAll().subscribe((data) => {
      if(data.body != null) {
        this.User = data.body;
        console.log("Body: " + this.User);
       // console.log(this.loginComponent.Login.name)
      }
    })*/
  
/*
  growTable(){
     this.User;
  }

  reverseTable(){
    this.User.reverse();
  }
*/

