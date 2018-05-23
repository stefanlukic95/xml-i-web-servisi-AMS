import { Korisnik } from './korisnik';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class KorisnikService {

  private url_signup = 'http://localhost:8080/signup';
  private url_korisnik = 'http://localhost:8080/user';

  insertKorisnik(korisnik: Korisnik): Observable<Korisnik> {
    return this.http.post<Korisnik>(this.url_signup, korisnik, httpOptions);
  }

  getKorisnik(id: any): Observable<Korisnik> {
    return this.http.get<Korisnik>(this.url_korisnik + '/' + id.sub + '/');
  }

  constructor(private http: HttpClient) { }

}
