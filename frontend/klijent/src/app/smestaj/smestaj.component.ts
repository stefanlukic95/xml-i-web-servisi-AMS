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

  constructor(private smestajService: SmestajService) { }

  ngOnInit() {
  }

  search() {
    this.smestajService.search(this.model).subscribe(
      data => {
        this.smestaj = data;
      }
    );
  }

}
