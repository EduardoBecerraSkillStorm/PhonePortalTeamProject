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

  //angular has built in http functionality instead of using axios, imported above:
  constructor(private httpClient: HttpClient,
    private http: HttpClient
    ) { }

 findAll(): Observable<HttpResponse<User[]>> {
   return this.http.get<User[]>(this.url, { observe: 'response' });
  }


  sendLogin(login: Login): Observable<Login>  {
    return this.httpClient.get<Login>(`http://localhost:8085/existinguser2?name=${login.name}&pass=${login.pass}`);
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
