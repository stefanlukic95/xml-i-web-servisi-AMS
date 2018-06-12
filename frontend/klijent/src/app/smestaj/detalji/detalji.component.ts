import { KorisnikService } from './../../korisnik/korisnik.service';
import { AlertService } from './../../alert/alert.service';
import { Komentar } from './../../model/komentar';
import { KomentarService } from './../../services/komentar.service';
import { SmestajComponent } from './../smestaj.component';
import { Smestaj } from './../smestaj';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SmestajService } from '../smestaj.service';
import { TokenStorage } from '../../login-core/token-storage';
import * as jwt_decode from 'jwt-decode';
import { Korisnik } from '../../korisnik/korisnik';
import { RezervacijaService } from '../../services/rezervacija.service';
import { Rezervacija } from '../../model/rezervacija';

@Component({
  selector: 'app-detalji',
  templateUrl: './detalji.component.html',
  styleUrls: ['./detalji.component.css']
})

export class DetaljiComponent implements OnInit {
  smestajId: string;
  smestaj: Smestaj;
  date1: string;
  date2: string;
  koment: string;
  komentar: Komentar;
  ime: string;
  korisnik: Korisnik;
  rezervacija: Rezervacija;
  dopustenKomentar = false;

  constructor(
    private route: ActivatedRoute,
    private smestajService: SmestajService,
    private komentarService: KomentarService,
    private token: TokenStorage,
    private alertService: AlertService,
    private router: Router,
    private korisnikService: KorisnikService,
    private rezervacijaService: RezervacijaService
    ) {}

  ngOnInit() {
    if (this.route.snapshot.params['smestajId']) {
      this.route.params.subscribe((params: Params) => {
        this.smestajId = params['smestajId'];
        this.getSmestaj(this.smestajId);
        this.date1 = localStorage.getItem('date1');
        this.date2 = localStorage.getItem('date2');
      });
    }
    if (this.token.getToken() !== null) {
      this.korisnikService.getKorisnik(jwt_decode(this.token.getToken())).subscribe(
        data => {
          this.korisnik = data;
          for (const rez of this.korisnik.rezervacije) {
            if (rez.smestajId === this.smestajId && rez.izvrsena) {
              this.dopustenKomentar = true;
            }
          }
        }
      );
    }
  }

  getSmestaj(id: string) {
    this.smestajService.getSmestaj(id).subscribe(
      data => {
        this.smestaj = data;
        this.smestaj.cena = Number(localStorage.getItem(this.smestajId));
      }
    );
  }

  addComment() {
    if (this.token.getToken() === null) {
      this.alertService.error('Morate biti ulogovani da bi postavili komentar', true);
      this.router.navigate(['login']);
    } else {
      this.sendKomentar();
      (<HTMLInputElement>document.getElementById('txtarea')).value = '';
      this.alertService.success('Komentar je poslat na odobravanje');
    }
  }


  sendKomentar() {
    this.korisnikService.getKorisnik(jwt_decode(this.token.getToken())).subscribe(
      data => {
        this.ime = data.ime;
        this.komentar = new Komentar(this.koment , false, this.ime );
        console.log(this.komentar);
        this.komentarService.addKomentar(this.komentar, this.smestajId).subscribe();
      }
    );
  }

  rezervisi() {
    if (this.token.getToken() === null) {
      this.alertService.error('Morate biti ulogovani da bi rezervisali smestaj', true);
      this.router.navigate(['login']);
    } else {
      this.alertService.success('Uspesno ste rezervisali smestaj');
      this.rezervacija = new Rezervacija(new Date(this.date1) , new Date(this.date2), this.smestaj.cena);
      this.rezervacijaService.addRezervacija(this.rezervacija, this.smestajId, this.korisnik.id).subscribe();
    }
  }
}
