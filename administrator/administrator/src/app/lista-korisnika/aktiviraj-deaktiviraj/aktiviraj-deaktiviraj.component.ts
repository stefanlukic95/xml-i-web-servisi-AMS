import { Component, OnInit } from '@angular/core';
import { KorisniciService } from '../../korisnici.service';
import { Korisnikp } from '../../modeli/korisnici-prikaz';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { NgForm } from '@angular/forms/src/directives/ng_form';

@Component({
  selector: 'app-aktiviraj-deaktiviraj',
  templateUrl: './aktiviraj-deaktiviraj.component.html',
  styleUrls: ['./aktiviraj-deaktiviraj.component.css']
})
export class AktivirajDeaktivirajComponent implements OnInit {

  korisnik: Korisnikp;
  korisnikId: string;
  korisnikEdit: Korisnikp;


  getKorisnik() {
    this.korisniciService.getKorisnik(this.korisnikId).subscribe(
      (korisnik) => this.korisnikEdit = korisnik
    );
  }

  constructor(private korisniciService: KorisniciService,
            private location: Location,
            private route: ActivatedRoute) { }

  ngOnInit() {
    if(this.route.snapshot.params['korisnikId']){
      this.route.params.subscribe(
        (params: Params) => {
          this.korisnikId = params["korisnikId"];
        }
      );
      this.getKorisnik();
    }  
  }

  adkorisnikEdt() {
    this.korisniciService.adKorisnik(this.korisnikEdit).subscribe();
    this.location.back();
  }

}
