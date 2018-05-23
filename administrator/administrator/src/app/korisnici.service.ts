import { Injectable } from '@angular/core';
import { Korisnik } from './modeli/korisnici';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class KorisniciService {

  private url = 'http://localhost:8080/korisnici';


  insertKorisnik(korisnik: Korisnik): Observable<Korisnik> {
    return this.http.post<Korisnik>(this.url, korisnik, httpOptions).pipe(
      catchError(this.handleError<Korisnik>('insertKorisnik'))
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
