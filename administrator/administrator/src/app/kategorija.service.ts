import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Kategorija } from './modeli/kategorija';
import { NovaKategorija } from './modeli/nova-kategorija';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class KategorijaService {


  private url = 'http://localhost:8080/kategorija';


  getKategorije(): Observable<Kategorija[]> {
    return this.http.get<Kategorija[]>(this.url);

  }
  getKategorija(id: string): Observable<Kategorija> {
    return this.http.get<Kategorija>(this.url + '/' + id);
  }

  insertKategorija(kategorija: NovaKategorija): Observable<NovaKategorija> {
    return this.http.post<NovaKategorija>(this.url, kategorija, httpOptions).pipe(
      catchError(this.handleError<NovaKategorija>('insertKategorija'))
    );
  }

  updateKategorija(kategorija: Kategorija): Observable<Kategorija> {
    const id = typeof kategorija === 'string' ? kategorija : kategorija.id;
    const url = `${this.url}/${id}`;
    return this.http.put<Kategorija>(url, kategorija, httpOptions).pipe(
      catchError(this.handleError<Kategorija>('updateKategorija'))
    );
  }

  deleteKategorija(kategorija: Kategorija | string): Observable<Kategorija> {
    const id = typeof kategorija === 'string' ? kategorija : kategorija.id;
    const url = `${this.url}/${id}`;

    return this.http.delete<Kategorija>(url, httpOptions).pipe(
      catchError(this.handleError<Kategorija>('deleteKategorija'))
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
