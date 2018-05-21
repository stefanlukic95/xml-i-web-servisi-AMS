import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Tipsmestaja } from './modeli/tipsmestaja';
import { NoviTipsmestaja } from './modeli/novi-tipsmestaja';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TipsmestajaService {


  private url = 'http://localhost:8080/tipsmestaja';


  getTipovismestaja(): Observable<Tipsmestaja[]> {
    return this.http.get<Tipsmestaja[]>(this.url);

  }
  getTipsmestaja(id: string): Observable<Tipsmestaja> {
    return this.http.get<Tipsmestaja>(this.url + '/' + id);
  }

  insertTipSmestaja(tipsmestaja: NoviTipsmestaja): Observable<NoviTipsmestaja> {
    return this.http.post<NoviTipsmestaja>(this.url, tipsmestaja, httpOptions).pipe(
      catchError(this.handleError<NoviTipsmestaja>('insertTipsmestaja'))
    );
  }

  updateTipsmestaja(tipsmestaja: Tipsmestaja): Observable<Tipsmestaja> {
    const id = typeof tipsmestaja === 'string' ? tipsmestaja : tipsmestaja.id;
    const url = `${this.url}/${id}`;
    return this.http.put<Tipsmestaja>(url, tipsmestaja, httpOptions).pipe(
      catchError(this.handleError<Tipsmestaja>('updateTipsmestaja'))
    );
  }

  deleteTipsmestaja(tipsmestaja: Tipsmestaja | string): Observable<Tipsmestaja> {
    const id = typeof tipsmestaja === 'string' ? tipsmestaja : tipsmestaja.id;
    const url = `${this.url}/${id}`;

    return this.http.delete<Tipsmestaja>(url, httpOptions).pipe(
      catchError(this.handleError<Tipsmestaja>('deleteTipsmestaja'))
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
