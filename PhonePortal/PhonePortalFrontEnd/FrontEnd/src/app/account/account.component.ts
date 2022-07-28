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
  user: User = new User ("","","","", 0,"","","","","","","",0);


  constructor(private userService: UserService,
              private persister: PersistanceService
   // private loginComponent: LoginComponent 
    ) { }
 
    ngOnInit(): void {
      let user: any;
      const currentUser = this.persister.get('currentUser');
      console.log("this is currentUser: " + JSON.stringify(currentUser));
      //thisUser: User = new User (currentUser);
      
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
}
