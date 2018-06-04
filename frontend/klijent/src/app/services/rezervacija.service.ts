import { Observable } from 'rxjs/Observable';
import { Rezervacija } from './../model/rezervacija';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable()
export class RezervacijaService {

  private url = 'http://localhost:8080/rezervacija';

  constructor(private http: HttpClient) { }

  addRezervacija(rezervacija: Rezervacija, smestajId: string, korisnikId: string): Observable<Rezervacija> {
    return this.http.post<Rezervacija>(this.url + '/' + smestajId + '/' + korisnikId, rezervacija, httpOptions);
  }
}
