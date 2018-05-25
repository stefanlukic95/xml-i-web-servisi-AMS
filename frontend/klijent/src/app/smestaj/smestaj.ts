import { DodatnaUsluga } from './../model/dodatna-usluga';
import { Termin } from './../model/termin';
import { KategorijaSmestaja } from './../model/kategorija-smestaja';
import { Korisnik } from './../korisnik/korisnik';
import { NaseljenoMesto } from './../model/naseljeno-mesto';
import { Rezervacija } from './../model/rezervacija';
import { TipSmestaja } from '../model/tip-smestaja';
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
