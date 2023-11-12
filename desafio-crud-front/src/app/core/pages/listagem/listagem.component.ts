import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared/user.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.scss']
})
export class ListagemComponent implements OnInit {

  users:User[] = [];

  constructor(private userService:UserService) {}

  ngOnInit(): void {
    this.findUserTest();
    this.findUser();
  }

  findUserTest() {
    this.userService.getUserTest()
      .subscribe(arg => console.log(arg));
  }

  findUser() {
    this.userService.getUsers()
      .subscribe(arg =>this.users = arg);
  }

}
