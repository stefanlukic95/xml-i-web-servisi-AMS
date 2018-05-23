import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { KorisniciService } from '../korisnici.service';
import { Korisnik } from '../modeli/korisnici';


@Component({
  selector: 'app-korisnici',
  templateUrl: './korisnici.component.html',
  styleUrls: ['./korisnici.component.css']
})
export class KorisniciComponent implements OnInit {

noviKorisnik: Korisnik = new Korisnik("","","","");
korisnici: Korisnik[];

  constructor(private korisniciService: KorisniciService,
              private location: Location,
              ) { }

              noviKorisnikSubmit(forma: NgForm) {
                this.noviKorisnik.ime = forma.value.ime;
                this.noviKorisnik.prezime = forma.value.prezime;
                this.noviKorisnik.adresa = forma.value.adresa;
                this.noviKorisnik.pmb = forma.value.pmb;
                this.noviKorisnik.uloga = forma.value.uloga;
            
               
                this.korisniciService.insertKorisnik(this.noviKorisnik).subscribe();
                forma.reset();
                this.location.back();
              }
            

  ngOnInit() {
  }

}
