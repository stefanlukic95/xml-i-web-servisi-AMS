import { KorisnikService } from './../korisnik/korisnik.service';
import { Korisnik } from './../korisnik/korisnik';
import { Component, OnInit } from '@angular/core';
import { TokenStorage } from '../login-core/token-storage';
import * as jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  korisnik = new Korisnik('', '', '', '', '', '');

  constructor(
    private korisnikService: KorisnikService,
    private token: TokenStorage,
  ) { }

  ngOnInit() {
    if (this.token.getToken() != null) {
      this.getUser();
    }
  }

  getUser() {
    this.korisnikService.getKorisnik(jwt_decode(this.token.getToken())).subscribe(
      data => {
        this.korisnik = data;
      }
    );
  }

}
