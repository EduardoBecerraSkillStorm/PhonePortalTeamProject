import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'; 
import { Router } from '@angular/router';
import { Login } from '../models/login.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    Login: Login = new Login ("", "");

  constructor(
    private userService: UserService, 
    private router: Router
  ) { }

  ngOnInit(): void {

  }



  onSubmit(form:NgForm ) { 
    if(this.Login.username != "" && this.Login.password != "") {
      this.userService.sendLogin(this.Login).subscribe(info => {
        let route = this.router.config.find(r => r.path === 'account');
        if (route) {
          this.router.navigateByUrl('/account');
        }
      })
    }
    //alert("Hello "  + JSON.stringify(this.data));
  }
     
  /*
  on()
  {
    //send to back end
    //if dont get response or is Null, cant login
  }*/

}
