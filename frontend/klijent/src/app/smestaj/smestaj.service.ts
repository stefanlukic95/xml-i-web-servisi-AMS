import { DodatnaUsluga } from './../model/dodatna-usluga';
import { KategorijaSmestaja } from './../model/kategorija-smestaja';
import { TipSmestaja } from './../model/tip-smestaja';
import { Smestaj } from './smestaj';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json'})
};
@Injectable()
export class SmestajService {

  private url_smestaj = 'http://localhost:8080/smestaj';
  private url_tip = 'http://localhost:8080/tipsmestaja';
  private url_kategorija = 'http://localhost:8080/kategorija';
  private url_dodatnaUsl = 'http://localhost:8080/dodatneusluge';
  private url_check_dod = '';
  private url_check_tip = '';
  private url_check_kat = '';


  constructor(private http: HttpClient) { }

  search(model: any, dodatne: String[], tipovi: String[], kategorije: String[]) {
    this.url_check_dod = '';
    this.url_check_kat = '';
    this.url_check_tip = '';
    if (dodatne.length !== 0) {
      for (const d of dodatne) {
        this.url_check_dod = this.url_check_dod + '&dodatna=' + d;
      }
    }
    if (tipovi.length !== 0) {
      for (const t of tipovi) {
        this.url_check_tip = this.url_check_tip + '&tip=' + t;
      }
    }
    if (kategorije.length !== 0) {
      for (const k of kategorije) {
        this.url_check_kat = this.url_check_kat + '&kategorija=' + k;
      }
    }
    return this.http.get<Smestaj[]>(this.url_smestaj + '/search?mesto=' + model.mesto + '&brOsoba=' + model.br_mesta +
    '&datumOd=' + model.datumOd + '&datumDo=' + model.datumDo + this.url_check_dod + this.url_check_tip + this.url_check_kat);
  }

  getTipovi() {
    return this.http.get<TipSmestaja[]>(this.url_tip, httpOptions);
  }

  getKategorije() {
    return this.http.get<KategorijaSmestaja[]>(this.url_kategorija, httpOptions);
  }

  getDodatne() {
    return this.http.get<DodatnaUsluga[]>(this.url_dodatnaUsl, httpOptions);
  }

}
