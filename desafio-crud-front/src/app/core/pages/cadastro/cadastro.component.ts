import { User } from './../../model/user';
import { Component } from '@angular/core';
import { UserService } from '../../shared/user.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent {

  constructor(private userService:UserService){}

  user:User | undefined;

  idUser:number = 1;
  userSave!:User;

  consultar() {
    this.userService.getUser(this.idUser)
      .subscribe(arg => this.user = arg);
  }

  saveUser() {
    this.userService.saveUser(this.userSave)
      .subscribe(arg => console.log());
  }

  deleteUser() {
    this.userService.deleteUser(this.idUser)
      .subscribe(arg => console.log());
  }

}
