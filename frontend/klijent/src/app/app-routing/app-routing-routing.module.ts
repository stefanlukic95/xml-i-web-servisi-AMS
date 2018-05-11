import { NgModule } from '@angular/core';
import { Routes, RouterModule,Router } from '@angular/router';
import { SmestajComponent } from '../smestaj/smestaj.component';

const routes: Routes = [
  {path: 'smestaj', component: SmestajComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingRoutingModule { }
