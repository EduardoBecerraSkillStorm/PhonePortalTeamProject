import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { UserService } from '../services/user.service';
import {LoginComponent} from '../login/login.component';
import { PersistanceService } from '../services/persistence.service';


@Component({
  selector: 'app-user-plan',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  thisUser: User = new User ("","","","", 0,"","","","","","","",0);
  device: string = "";
  userPlan: string = "";
  activateDevices: boolean = false;
  phoneNumber: string = "";

  constructor(private userService: UserService,
              private persister: PersistanceService
   // private loginComponent: LoginComponent 
    ) { }
 
    ngOnInit(): void {
      let user: any;
      const currentUser = this.persister.get('currentUser');
      console.log("this is currentUser: " + JSON.stringify(currentUser));
      //thisUser: User = new User (currentUser);
      let name = currentUser.name;
      console.log("name: " + name);
      this.thisUser = new User (currentUser.device_name_1, currentUser.device_name_2, currentUser.device_name_3,currentUser.device_name_4,currentUser.monthly_price,currentUser.name,currentUser.pass_word,currentUser.phone_number_1,currentUser.phone_number_2,currentUser.phone_number_3,currentUser.phone_number_4,currentUser.plan_name,currentUser.user_id);
      /*
      this.thisUser.device_name_1 = this.device;
      console.log("device updated: " + JSON.stringify(this.thisUser));
      console.log(this.device); */
    }


      updateUserPlan(): void {
        this.thisUser.plan_name= this.userPlan;
        if (this.thisUser.plan_name = "Standard" || "Ultimate") {
          this.activateDevices = true;
        }
        console.log("device updated: " + JSON.stringify(this.thisUser));
        console.log(this.device);
      }


      updateDevice(): void {
        this.thisUser.device_name_1 = this.device;
        console.log("device updated: " + JSON.stringify(this.thisUser));
        console.log(this.device);
      }

      updatePhoneNumber(): void {
        this.thisUser.phone_number_1 = this.phoneNumber;
        console.log("device updated: " + JSON.stringify(this.thisUser));
        console.log(this.thisUser.phone_number_1);
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

