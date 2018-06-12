import { Poruka } from './poruka';
import { Rezervacija } from './rezervacija';
export class Korisnik {
  constructor(
    public ime: string,
    public prezime: string,
    public email: string,
    public password: string,
    public brtel: string,
    public adresa: string,
    public pmb: string,
    public rezervacije: Array<Rezervacija>,
    public poruke: Array<Poruka>,
    public id?: string
  ) { }
}
