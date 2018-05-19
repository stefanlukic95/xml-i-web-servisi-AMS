import { Korisnik } from './korisnik';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class KorisnikService {

  private url = 'http://localhost:8080/signup';

  insertKorisnik(korisnik: Korisnik): Observable<Korisnik> {
    return this.http.post<Korisnik>(this.url, korisnik, httpOptions);
  }

  constructor(private http: HttpClient) { }

}
