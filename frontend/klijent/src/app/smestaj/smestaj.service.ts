import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json'})
};
@Injectable()
export class SmestajService {

  private url_smestaj = 'http://localhost:8080/smestaj';

  constructor(private http: HttpClient) { }

}
