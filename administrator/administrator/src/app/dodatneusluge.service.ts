import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Dodatneusluge } from './modeli/dodatneusluge';
import { NoveDodatneusluge } from './modeli/nove-dodatneusluge';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class DodatneuslugeService {


  private url = 'http://localhost:8080/dodatneusluge';


  getDodatneusluge(): Observable<Dodatneusluge[]> {
    return this.http.get<Dodatneusluge[]>(this.url);

  }
  getDodatnausluga(id: string): Observable<Dodatneusluge> {
    return this.http.get<Dodatneusluge>(this.url + '/' + id);
  }

  insertDodatnausluga(dodatnausluga: NoveDodatneusluge): Observable<NoveDodatneusluge> {
    return this.http.post<NoveDodatneusluge>(this.url, dodatnausluga, httpOptions).pipe(
      catchError(this.handleError<NoveDodatneusluge>('insertDodatnausluga'))
    )
  }

  updateDodatnausluga(dodatnausluga: Dodatneusluge): Observable<Dodatneusluge> {
    const id = typeof dodatnausluga === 'string' ? dodatnausluga : dodatnausluga.id;
    const url = `${this.url}/${id}`;
    return this.http.put<Dodatneusluge>(url, dodatnausluga, httpOptions).pipe(
      catchError(this.handleError<Dodatneusluge>('updateDodatnausluga'))
    );
  }

  deleteDodatnausluga(dodatnausluga: Dodatneusluge | string): Observable<Dodatneusluge> {
    const id = typeof dodatnausluga === 'string' ? dodatnausluga : dodatnausluga.id;
    const url = `${this.url}/${id}`;

    return this.http.delete<Dodatneusluge>(url, httpOptions).pipe(
      catchError(this.handleError<Dodatneusluge>('deleteDodatnausluga'))
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
