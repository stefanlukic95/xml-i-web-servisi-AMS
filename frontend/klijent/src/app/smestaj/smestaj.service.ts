import { Smestaj } from './smestaj';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json'})
};
@Injectable()
export class SmestajService {

  private url_smestaj = 'http://localhost:8080/smestaj';


  constructor(private http: HttpClient) { }

  search(model: any) {
    return this.http.get<Smestaj[]>(this.url_smestaj + '/search?mesto=' + model.mesto + '&brOsoba=' + model.br_mesta +
    '&datumOd=' + model.datumOd + '&datumDo=' + model.datumDo);
  }

}
