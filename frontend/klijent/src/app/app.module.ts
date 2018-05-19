import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import { KorisnikService } from './korisnik/korisnik.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavComponentComponent } from './nav-component/nav-component.component';
import { AppRoutingRoutingModule } from './app-routing/app-routing-routing.module';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { RouterModule } from '@angular/router/src/router_module';
import { HeaderComponent } from './header/header.component';
import { SmestajComponent } from './smestaj/smestaj.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    NavComponentComponent,
    HeaderComponent,
    SmestajComponent,
    RegistracijaComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppRoutingRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    KorisnikService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
