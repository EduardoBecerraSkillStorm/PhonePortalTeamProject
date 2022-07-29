import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { Login } from '../models/login.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = "http://localhost:8085/allusers";
  urlLogin: string = "http://localhost:8085/existinguser";
  urlget: string = "http://localhost:8085/getuser";

  //angular has built in http functionality instead of using axios, imported above:
  constructor(private httpClient: HttpClient,
    private http: HttpClient
    ) { }

 findAll(): Observable<HttpResponse<User[]>> {
   return this.http.get<User[]>(this.url, { observe: 'response' });
  }

  

  sendLogin(login: Login): Observable<Login>  {
    let words = login.pass;
    let encrypted = "";
    for(var char of words) {
      let letter = String.fromCharCode(char.charCodeAt(0) + 1);
      encrypted = encrypted + letter;
    }

    return this.httpClient.get<Login>(`http://localhost:8085/existinguser2?name=${login.name}&pass=${encrypted}`);
}

updateUser(currentUser: Login, user: User): Observable<Object>{
  console.log("login.name: " + currentUser.name);
  console.log("login.pass: " + currentUser.pass);
  console.log("user: ");
  return this.httpClient.put(`http://localhost:8085/edituser?name=${currentUser.name}&pass=${currentUser.pass}`, user);
}
  
  findbyid(login: Login): Observable<Login> {    
    return this.httpClient.get<Login>("http://localhost:8085/getuser/" + login);
  }


//sendLogin(login: Login): Observable<HttpResponse<Login>> {
 //    const body = { name : "dude",
//                    pass_word : 1234 };
 //   return this.http.get<Login>('http://localhost:8085/existinguser',{ observe: 'response' });
//  }

   //findUser(): 




  /*
  findUserPlan(): Observable<> {
    return this.http.get<User.plan>(this.url);
  }
   */


  
}
