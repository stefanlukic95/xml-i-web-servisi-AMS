import { KorisnikService } from './../korisnik/korisnik.service';
import { Router } from '@angular/router';
import { TokenStorage } from './../login-core/token-storage';
import { Component, OnInit } from '@angular/core';
import * as jwtDecode from 'jwt-decode';


@Component({
  selector: 'app-nav-component',
  templateUrl: './nav-component.component.html',
  styleUrls: ['./nav-component.component.css']
})
export class NavComponentComponent implements OnInit {

  ime: string;
  prezime: string;
  isLoggedIn = false;

  constructor(
    private token: TokenStorage,
    private router: Router,
    private korisnikService: KorisnikService
  ) { }

  ngOnInit() {
    if (this.token.getToken() != null) {
      this.getUser();
    }
  }

  logout(): void {
    this.token.signOut();
    this.router.navigate(['login']);
    console.log('token: ' + this.token.getToken());
  }

  getUser() {
    this.korisnikService.getKorisnik(jwtDecode(this.token.getToken())).subscribe(
      data => {
        this.ime = data.ime;
        this.prezime = data.prezime;
      }
    );
  }


}
