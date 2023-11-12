import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private readonly API_URL = 'http://localhost:8080/api/users';

  constructor(private httpClient:HttpClient) { }


  getUserTest() {
    return this.httpClient.get<User>(this.API_URL + '/user');
  }

  getUsers() {
    return this.httpClient.get<User[]>(this.API_URL);
  }

  saveUser(user:User) {
    return this.httpClient.post<User>(this.API_URL, user);
  }

  updateUser(user:User) {
    return this.httpClient.put<User>(this.API_URL, user);
  }

  getUser(idUser:number) {
    return this.httpClient.get<User>(`${this.API_URL}/${idUser}`);
  }

  deleteUser(idUser:number) {
    return this.httpClient.delete(`${this.API_URL}/${idUser}`);
  }

}
