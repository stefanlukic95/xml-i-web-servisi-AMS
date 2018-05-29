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


  constructor(private smestajService: SmestajService) { }

  ngOnInit() {
    this.smestajService.getTipovi().subscribe(
      data => {
        this.tipovi = data;
      }
    );
    this.smestajService.getKategorije().subscribe(
      data => {
        this.kategorije = data;
      }
    );
    this.smestajService.getDodatne().subscribe(
      data => {
        this.dodatneUsl = data;
      }
    );
  }

  search() {
    this.smestajService.search(this.model).subscribe(
      data => {
        this.smestaj = data;
      }
    );
    this.rezultati = true;
  }

  toggleDetaljno() {
    this.detaljno = !this.detaljno;
  }

}
