export class Korisnik {
  constructor(
    public ime: string,
    public prezime: string,
    public email: string,
    public password: string,
    public brtel: string,
    public pmb: string,
    public id?: string
  ) { }
}
