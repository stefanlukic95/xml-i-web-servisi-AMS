import { Component, OnInit } from '@angular/core';
import { KategorijaService } from '../../kategorija.service';
import { NovaKategorija } from '../../modeli/nova-kategorija';
import { Kategorija } from '../../modeli/kategorija';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { NgForm } from '@angular/forms/src/directives/ng_form';


@Component({
  selector: 'app-kategorija-edit',
  templateUrl: './kategorija-edit.component.html',
  styleUrls: ['./kategorija-edit.component.css']
})
export class KategorijaEditComponent implements OnInit {
  novaKategorija: NovaKategorija= new NovaKategorija("");
  kategorijaId: string;
  kategorijaEdit: Kategorija;
  kategorije: Kategorija[];

  constructor(private kategorijaService: KategorijaService,
              private location: Location,
              private route: ActivatedRoute) { }


              getKategorija() {
                this.kategorijaService.getKategorija(this.kategorijaId).subscribe(
                  (kategorija) => this.kategorijaEdit = kategorija
                );
              }

              
  ngOnInit() {

    if(this.route.snapshot.params['kategorijaId']){
      this.route.params.subscribe(
        (params: Params) => {
          this.kategorijaId = params["kategorijaId"];
        }
      );
      this.getKategorija();
    }  
  }

  novaKategorijaSubmit(forma: NgForm) {
    this.novaKategorija.naziv = forma.value.naziv;
   
    this.kategorijaService.insertKategorija(this.novaKategorija).subscribe();
    forma.reset();
    this.location.back();
  }



  kategorijaUpdtSubmit(forma: NgForm){
    this.kategorijaEdit.naziv = forma.value.naziv;
    this.kategorijaService.updateKategorija(this.kategorijaEdit).subscribe();
    forma.reset();
    this.location.back();
  }

  kategorijaEdt() {
    this.kategorijaService.updateKategorija(this.kategorijaEdit).subscribe();
    this.location.back();
  }


}
