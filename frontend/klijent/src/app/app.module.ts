import { Interceptor } from './login-core/interceptor';
import { ToggleLoginService } from './login/toggle-login.service';
import { AlertService } from './alert/alert.service';
import { AuthService } from './login-core/auth.service';
import { HttpClient, HttpHandler, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
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
import { LoginComponent } from './login/login.component';
import { TokenStorage } from './login-core/token-storage';
import { AlertComponent } from './alert/alert.component';
import { ProfilComponent } from './profil/profil.component';
import { DetaljnaPretragaComponent } from './detaljna-pretraga/detaljna-pretraga.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponentComponent,
    HeaderComponent,
    SmestajComponent,
    RegistracijaComponent,
    LoginComponent,
    AlertComponent,
    ProfilComponent,
    DetaljnaPretragaComponent,

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
    AuthService,
    TokenStorage,
    AlertService,
    ToggleLoginService,
    {provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi : true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
