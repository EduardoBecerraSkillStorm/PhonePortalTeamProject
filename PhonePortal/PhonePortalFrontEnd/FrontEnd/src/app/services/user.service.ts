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

  //angular has built in http functionality instead of using axios, imported above:
  constructor(private http: HttpClient) { }


  findAll(): Observable<HttpResponse<User[]>> {
    return this.http.get<User[]>(this.url, { observe: 'response' });
  }

  sendLogin(login: Login): Observable<HttpResponse<Login>> {
    return this.http.post<Login>(this.url, JSON.stringify(login), { observe: 'response' });
  }

   //findUser(): 




  /*
  findUserPlan(): Observable<> {
    return this.http.get<User.plan>(this.url);
  }
   */


  
}
