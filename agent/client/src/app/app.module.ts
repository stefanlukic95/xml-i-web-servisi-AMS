import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { SmestajComponent } from './smestaj/smestaj.component';
import { RezervacijaComponent } from './rezervacija/rezervacija.component';
import { PorukaComponent } from './poruka/poruka.component';
import { PorukaService } from 'src/app/poruka.service';
import { Rezervacija } from 'src/app/modeli/rezervacija';
import { RezervacijaService } from 'src/app/rezervacija.service';
import { SmestajService } from 'src/app/smestaj.service';
import { NavComponentComponent } from './nav-component/nav-component.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    SmestajComponent,
    RezervacijaComponent,
    PorukaComponent,
    NavComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    
    
  ],
  providers: [
    PorukaService,
    RezervacijaService,
    SmestajService


  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
