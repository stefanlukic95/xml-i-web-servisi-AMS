import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipsmestajaComponent } from './tipsmestaja/tipsmestaja.component';
import { TipsmestajaEditComponent } from './tipsmestaja/tipsmestaja-edit/tipsmestaja-edit.component';
import { KategorijaComponent } from './kategorija/kategorija.component';
import { KategorijaEditComponent } from './kategorija/kategorija-edit/kategorija-edit.component';
import { DodatneuslugeComponent } from './dodatneusluge/dodatneusluge.component';
import { DodatneuslugeEditComponent } from './dodatneusluge/dodatneusluge-edit/dodatneusluge-edit.component';
import { KorisniciComponent } from './korisnici/korisnici.component';
import { ListaKorisnikaComponent } from './lista-korisnika/lista-korisnika.component';
import { AktivirajDeaktivirajComponent } from './lista-korisnika/aktiviraj-deaktiviraj/aktiviraj-deaktiviraj.component';
import { KomentariComponent } from './komentari/komentari.component';
import { OdobravanjeKomentaraComponent } from './komentari/odobravanje-komentara/odobravanje-komentara.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: 'tipsmestaja', component: TipsmestajaComponent},
  {path: 'tipsmestaja/:tipsmestajaId', component: TipsmestajaEditComponent},
  {path: 'kategorija', component: KategorijaComponent},
  {path: 'kategorija/:kategorijaId', component: KategorijaEditComponent},
  {path: 'dodatneusluge', component: DodatneuslugeComponent},
  {path: 'dodatneusluge/:dodatnauslugaId', component: DodatneuslugeEditComponent},
  {path: 'tipsmestaja-edit', component: TipsmestajaEditComponent},
  {path: 'kategorija-edit', component: KategorijaEditComponent},
  {path: 'dodatneusluge-edit', component: DodatneuslugeEditComponent},
  {path: 'korisnici', component: KorisniciComponent},
  {path: 'lista-korisnika', component: ListaKorisnikaComponent},
  {path: 'lista-korisnika/:korisnikId', component: AktivirajDeaktivirajComponent},
  {path: 'komentari', component: KomentariComponent},
  {path: 'komentari/:komentarId', component: OdobravanjeKomentaraComponent},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
