import { KorisnikService } from './../korisnik/korisnik.service';
import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../korisnik/korisnik';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  korisnik = new Korisnik('', '', '', '', '', '');

  constructor(private korisnikService: KorisnikService) { }

  ngOnInit() {

  }

  registruj() {
    this.korisnikService.insertKorisnik(this.korisnik).subscribe();
  }

}
