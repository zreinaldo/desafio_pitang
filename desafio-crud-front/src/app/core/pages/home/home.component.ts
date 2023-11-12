import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../shared/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent  {


  constructor(private authService:AuthService){}

  isLogado:boolean = false;

  async ngOnInit() {
    this.isLogado = await this.authService.isLogado();
  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }
}
