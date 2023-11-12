import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './core/layout/header/header.component';
import { MainComponent } from './core/layout/main/main.component';
import { FooterComponent } from './core/layout/footer/footer.component';
import { HomeComponent } from './core/pages/home/home.component';
import { ListagemComponent } from './core/pages/listagem/listagem.component';
import { HttpClientModule } from '@angular/common/http';
import { CadastroComponent } from './core/pages/cadastro/cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    FooterComponent,
    HomeComponent,
    ListagemComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
