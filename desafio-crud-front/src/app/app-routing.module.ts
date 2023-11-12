import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './core/pages/home/home.component';
import { ListagemComponent } from './core/pages/listagem/listagem.component';
import { CadastroComponent } from './core/pages/cadastro/cadastro.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'listagem', component: ListagemComponent},
  {path: 'cadastro', component: CadastroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

