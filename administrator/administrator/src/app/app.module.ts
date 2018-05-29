import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponentComponent } from './nav-component/nav-component.component';
import { TipsmestajaComponent } from './tipsmestaja/tipsmestaja.component';
import { TipsmestajaService } from './tipsmestaja.service';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TipsmestajaEditComponent } from './tipsmestaja/tipsmestaja-edit/tipsmestaja-edit.component';
import { KategorijaComponent } from './kategorija/kategorija.component';
import { KategorijaService } from './kategorija.service';
import { KategorijaEditComponent } from './kategorija/kategorija-edit/kategorija-edit.component';
import { DodatneuslugeComponent } from './dodatneusluge/dodatneusluge.component';
import { DodatneuslugeEditComponent } from './dodatneusluge/dodatneusluge-edit/dodatneusluge-edit.component';
import { DodatneuslugeService } from './dodatneusluge.service';
import { KorisniciComponent } from './korisnici/korisnici.component';
import { KorisniciService } from './korisnici.service';
import { ListaKorisnikaComponent } from './lista-korisnika/lista-korisnika.component';
import { AktivirajDeaktivirajComponent } from './lista-korisnika/aktiviraj-deaktiviraj/aktiviraj-deaktiviraj.component';
import { KomentariComponent } from './komentari/komentari.component';
import { KomentariService } from './komentari.service';
import { OdobravanjeKomentaraComponent } from './komentari/odobravanje-komentara/odobravanje-komentara.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login.service';
import { TokenStorage } from './login-core/token-storage';
import { AuthService } from './login-core/auth.service';
import { Interceptor } from './login-core/interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavComponentComponent,
    TipsmestajaComponent,
    TipsmestajaEditComponent,
    KategorijaComponent,
    KategorijaEditComponent,
    DodatneuslugeComponent,
    DodatneuslugeEditComponent,
    KorisniciComponent,
    ListaKorisnikaComponent,
    AktivirajDeaktivirajComponent,
    KomentariComponent,
    OdobravanjeKomentaraComponent,
    LoginComponent,
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    
  ],
  providers: [
    TipsmestajaService,
    KategorijaService,
    DodatneuslugeService,
    KorisniciService,
    KomentariService,
    LoginService,
    TokenStorage,
    AuthService,
    {provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi : true},

    
   
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
