export class Rezervacija {
  constructor(
    public datumDolaska: Date,
    public datumOdlaska: Date,
    public cena?: number,
    public smestajNaziv?: string,
    public id?: string
  ) { }
}
