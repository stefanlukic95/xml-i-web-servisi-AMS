import { RegistracijaComponent } from './../registracija/registracija.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';
import { SmestajComponent } from '../smestaj/smestaj.component';
import { LoginComponent } from '../login/login.component';

const routes: Routes = [
  { path: 'smestaj', component: SmestajComponent },
  { path: 'registracija', component: RegistracijaComponent },
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingRoutingModule { }
