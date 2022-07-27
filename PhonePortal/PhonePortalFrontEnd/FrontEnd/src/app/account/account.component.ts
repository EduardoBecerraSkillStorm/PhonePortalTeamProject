import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-plan',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  User: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe((data) => {
      if(data.body != null) {
        this.User = data.body;
        console.log("Body: " + this.User);
      }
    });
  }

  growTable(){
     this.User;
  }

  reverseTable(){
    this.User.reverse();
  }

}
