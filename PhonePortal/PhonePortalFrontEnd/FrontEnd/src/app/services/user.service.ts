import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plan } from '../unused/plan.model';
import { UserPlan } from '../models/userplan.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = "http://localhost:8080/";

  //angular has built in http functionality instead of using axios, imported above:
  constructor(private http: HttpClient) { }


  findAll(): Observable<HttpResponse<UserPlan[]>> {
    return this.http.get<UserPlan[]>(this.url, { observe: 'response' });
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
