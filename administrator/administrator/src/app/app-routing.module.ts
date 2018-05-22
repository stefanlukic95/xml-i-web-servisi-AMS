import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipsmestajaComponent } from './tipsmestaja/tipsmestaja.component';
import { TipsmestajaEditComponent } from './tipsmestaja/tipsmestaja-edit/tipsmestaja-edit.component';
import { KategorijaComponent } from './kategorija/kategorija.component';
import { KategorijaEditComponent } from './kategorija/kategorija-edit/kategorija-edit.component';
import { DodatneuslugeComponent } from './dodatneusluge/dodatneusluge.component';
import { DodatneuslugeEditComponent } from './dodatneusluge/dodatneusluge-edit/dodatneusluge-edit.component';

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

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
