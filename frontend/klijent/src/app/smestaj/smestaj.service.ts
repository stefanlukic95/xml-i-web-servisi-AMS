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


  constructor(private http: HttpClient) { }

  search(model: any) {
    return this.http.get<Smestaj[]>(this.url_smestaj + '/search?mesto=' + model.mesto + '&brOsoba=' + model.br_mesta +
    '&datumOd=' + model.datumOd + '&datumDo=' + model.datumDo);
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
