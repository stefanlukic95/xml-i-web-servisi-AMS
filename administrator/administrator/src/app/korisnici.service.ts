import { Injectable } from '@angular/core';
import { Korisnik } from './modeli/korisnici';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Korisnikp } from './modeli/korisnici-prikaz';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class KorisniciService {

  private url = 'http://localhost:8080/korisnici';
  private url1 = 'http://localhost:8080/korisnici-list';



  getKorisnici(): Observable<Korisnikp[]> {
    return this.http.get<Korisnikp[]>(this.url1);

  }
  getKorisnik(id: string): Observable<Korisnikp> {
    return this.http.get<Korisnikp>(this.url1 + '/' + id);
  }

  insertKorisnik(korisnik: Korisnik): Observable<Korisnik> {
    return this.http.post<Korisnik>(this.url, korisnik, httpOptions).pipe(
      catchError(this.handleError<Korisnik>('insertKorisnik'))
    );
  }

  deleteKorisnik(korisnik: Korisnikp | string): Observable<Korisnikp> {
    const id = typeof korisnik === 'string' ? korisnik : korisnik.id;
    const url = `${this.url}/${id}`;

    return this.http.delete<Korisnikp>(url, httpOptions).pipe(
      catchError(this.handleError<Korisnikp>('deleteKorinsik'))
    );
  }
  
  adKorisnik(korisnik: Korisnikp): Observable<Korisnikp> {
    const id = typeof korisnik === 'string' ? korisnik : korisnik.id;
    const url1 = `${this.url1}/${id}`;
    return this.http.put<Korisnikp>(url1, korisnik, httpOptions).pipe(
      catchError(this.handleError<Korisnikp>('adKorisnik'))
    );
  }

  constructor(private http: HttpClient) { }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption


      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
