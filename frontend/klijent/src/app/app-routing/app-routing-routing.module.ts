import { DetaljnaPretragaComponent } from './../detaljna-pretraga/detaljna-pretraga.component';
import { ProfilComponent } from './../profil/profil.component';
import { RegistracijaComponent } from './../registracija/registracija.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';
import { SmestajComponent } from '../smestaj/smestaj.component';
import { LoginComponent } from '../login/login.component';

const routes: Routes = [
  { path: 'smestaj', component: SmestajComponent },
  { path: 'registracija', component: RegistracijaComponent },
  { path: 'login', component: LoginComponent},
  { path: 'profil', component: ProfilComponent },
  { path: 'smestaj/detaljna_pretraga', component: DetaljnaPretragaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingRoutingModule { }
