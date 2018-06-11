import { Router } from '@angular/router';
import { AlertService } from './../alert/alert.service';
import { TokenStorage } from './../login-core/token-storage';
import { SmestajService } from './smestaj.service';
import { DodatnaUsluga } from './../model/dodatna-usluga';
import { Termin } from './../model/termin';
import { KategorijaSmestaja } from './../model/kategorija-smestaja';
import { TipSmestaja } from './../model/tip-smestaja';
import { Korisnik } from './../korisnik/korisnik';
import { Rezervacija } from './../model/rezervacija';
import { NaseljenoMesto } from './../model/naseljeno-mesto';
import { Component, OnInit } from '@angular/core';
import { Smestaj } from './smestaj';

@Component({
  selector: 'app-smestaj',
  templateUrl: './smestaj.component.html',
  styleUrls: ['./smestaj.component.css']
})
export class SmestajComponent implements OnInit {
  smestaj: Smestaj[];
  model: any = {};
  detaljno = false;
  rezultati = false;
  tipovi: TipSmestaja[];
  kategorije: KategorijaSmestaja[];
  dodatneUsl: DodatnaUsluga[];
  izabraniTipovi = [];
  izabraneKategorije = [];
  izabraneDodatne = [];
  datumi = [];
  cena: number;
  date1: Date;
  date2: Date;
  cene = [];

  constructor(
    private smestajService: SmestajService,
    private token: TokenStorage,
    private alertService: AlertService,
    private router: Router
  ) {}

  ngOnInit() {
    this.smestajService.getTipovi().subscribe(data => {
      this.tipovi = data;
      for (const t of this.tipovi) {
        t.checked = false;
      }
    });
    this.smestajService.getKategorije().subscribe(data => {
      this.kategorije = data;
      for (const k of this.kategorije) {
        k.checked = false;
      }
    });
    this.smestajService.getDodatne().subscribe(data => {
      this.dodatneUsl = data;
      for (const d of this.dodatneUsl) {
        d.checked = false;
      }
    });
    // OVO JE PRIVREMENOOOO
    //
    //
    //
     this.smestajService.getSmestaje().subscribe(data => {
      this.smestaj = data;
      this.rezultati = true;
     });
    //
    //
    //
    //
    //
  }

  search() {
    this.izabraneDodatne = [];
    this.izabraneKategorije = [];
    this.izabraniTipovi = [];
    for (const d of this.dodatneUsl) {
      if (d.checked) {
        this.izabraneDodatne.push(d.id);
      }
    }
    for (const t of this.tipovi) {
      if (t.checked) {
        this.izabraniTipovi.push(t.id);
      }
    }
    for (const k of this.kategorije) {
      if (k.checked) {
        this.izabraneKategorije.push(k.id);
      }
    }
    this.datumi = [];
    this.datumi.push(this.model.datumOd);
    this.datumi.push(this.model.datumDo);
    localStorage.setItem('date1', this.datumi[0]);
    localStorage.setItem('date2', this.datumi[1]);
    this.smestajService
      .search(
        this.model,
        this.izabraneDodatne,
        this.izabraniTipovi,
        this.izabraneKategorije
      )
      .subscribe(data => {
        this.smestaj = data;
        if (this.smestaj.length === 0) {
          this.alertService.error(
            'Nijedan smestaj ne odgovara zadatom kriterijumu'
          );
        } else {
          // tslint:disable-next-line:prefer-const
          let i: number;
          for (i = 0; i < this.smestaj.length; i++) {
            this.date1 = new Date(this.model.datumOd);
            this.date2 = new Date(this.model.datumDo);
            this.smestaj[i].cena = 0;
            while (this.date1 <= this.date2) {
              this.smestaj[i].cena += this.smestaj[i].termini[this.date1.getMonth()].cena;
              this.date1 = new Date(this.date1.getTime() + (60 * 60 * 24 * 1000));
           }
           localStorage.setItem(this.smestaj[i].id, this.smestaj[i].cena.toString());
          }
          this.rezultati = true;
        }
      });
    window.scroll(0, 0);
  }

  toggleDetaljno() {
    this.detaljno = !this.detaljno;
  }

  reserve() {
    if (this.token.getToken() === null) {
      this.alertService.error(
        'Morate biti prijavljeni da biste rezervisali smestaj',
        true
      );
      this.router.navigate(['login']);
    }
  }
}
