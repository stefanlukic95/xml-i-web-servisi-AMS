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


  constructor(private smestajService: SmestajService) { }

  ngOnInit() {
    this.smestajService.getTipovi().subscribe(
      data => {
        this.tipovi = data;
        for (const t of this.tipovi) {
          t.checked = false;
        }
      }
    );
    this.smestajService.getKategorije().subscribe(
      data => {
        this.kategorije = data;
        for (const k of this.kategorije) {
          k.checked = false;
        }
      }
    );
    this.smestajService.getDodatne().subscribe(
      data => {
        this.dodatneUsl = data;
        for (const d of this.dodatneUsl) {
          d.checked = false;
        }
      }
    );
  }

  search() {
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
    console.log(this.izabraneDodatne);
    console.log(this.izabraneKategorije);
    console.log(this.izabraniTipovi);
    this.smestajService.search(this.model).subscribe(
      data => {
        this.smestaj = data;
      }
    );
    this.rezultati = true;
    console.log(this.dodatneUsl);
  }

  toggleDetaljno() {
    this.detaljno = !this.detaljno;
  }



}
