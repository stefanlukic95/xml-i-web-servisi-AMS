import { Component, OnInit, Input } from '@angular/core';
import { Korisnik } from '../modeli/korisnici';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { KorisniciService } from '../korisnici.service';
import { Korisnikp } from '../modeli/korisnici-prikaz';


@Component({
  selector: 'app-lista-korisnika',
  templateUrl: './lista-korisnika.component.html',
  styleUrls: ['./lista-korisnika.component.css']
})
export class ListaKorisnikaComponent implements OnInit {

  @Input() korisniciShow: Korisnikp;

  korisnici: Korisnikp[];
  korisnikId: string;
  korisnikEdit: Korisnikp;
  korisnik: Korisnikp;

  

  
  getKorisnici(): void {
    this.korisniciService.getKorisnici()
      .subscribe(korisnici => this.korisnici = korisnici);
  }
  
    getKorisnik() {
      this.korisniciService.getKorisnik(this.korisnikId).subscribe(
        (korisnik) => this.korisnikEdit = korisnik
      );
    }

    deleteKorisnik(korisnik: Korisnikp) {
      this.korisniciService.deleteKorisnik(korisnik).subscribe();
      this.korisnici = this.korisnici.filter(k => k !== korisnik);
    }

   
  constructor(private korisniciService: KorisniciService,
              private location: Location,
                 ) { }


  ngOnInit() {
    this.getKorisnici();
    console.log(this.korisnici);
  }

}
