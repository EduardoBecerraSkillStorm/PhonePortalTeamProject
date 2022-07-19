import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plan } from '../models/plan.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = "http://localhost:8080/";

  //angular has built in http functionality instead of using axios, imported above:
  constructor(private http: HttpClient) { }

  findAll(): Observable<HttpResponse<User[]>> {
    return this.http.get<User[]>(this.url, { observe: 'response' });
  }
  
  /*
  findUserPlan(): Observable<> {
    return this.http.get<User.plan>(this.url);
  }
   */


  addAPlan(plan: Plan): Observable<HttpResponse<Plan>> {
    return this.http.post<Plan>(this.url, plan, { observe: 'response' });
  }

  
}
