import { DodatnaUsluga } from './dodatna-usluga';
import { Termin } from './termin';
import { KategorijaSmestaja } from './kategorija-smestaja';
import { Korisnik } from './korisnik';
import { NaseljenoMesto } from './naseljeno-mesto';
import { Rezervacija } from './rezervacija';
import { TipSmestaja } from './tip-smestaja';

export class Smestaj {
    constructor(
      public naziv: string,
      public kapacitet: number,
      public naseljeno_mesto: NaseljenoMesto,
      public opis: string,
      public slika: string,
      public rezervacije: Array<Rezervacija>,
      public agent: Korisnik,
      public tipSmestaja: TipSmestaja,
      public kategorijaSmestaja: KategorijaSmestaja,
      public termini: Array<Termin>,
      public dodatne_usluge: Array<DodatnaUsluga>,
      public id?: string
    ) { }
}