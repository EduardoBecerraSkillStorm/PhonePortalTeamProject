import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'; 
import { Router } from '@angular/router';
import { Login } from '../models/login.model';
import { UserService } from '../services/user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
 
})
export class LoginComponent implements OnInit {
    Login: Login = new Login ("", "");

   // name: string
    //pass: string
    //login: Login

  constructor(
    private userService: UserService, 
    private router: Router,
    //private route: ActivatedRoute
  ) { }

  ngOnInit(): void {


}

//onsubmit(){
 // this.name = this.route.snapshot.params['name'];
  //this.pass = this.route.snapshot.params['pass'];

 // this.login = new Login(this.name, this.pass);
  //this.userService.sendLogin(this.name, this.pass).subscribe( data => console.log(data) );

    //this.http.get('some url ').subscribe(responseData => console.log(responseData));
 
 // }
  



onSubmit(form:NgForm ) { 
    if(this.Login.name != "" && this.Login.pass != "") {
     this.userService.sendLogin(this.Login).subscribe(loggedUser =>  { console.log(loggedUser)
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
