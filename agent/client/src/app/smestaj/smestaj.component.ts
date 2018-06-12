import { Component, OnInit, Input } from '@angular/core';
import { SmestajService } from 'src/app/smestaj.service';
import { Smestaj } from 'src/app/modeli/smestaj';
import { NgForm} from '@angular/forms/src/directives/ng_form';
import { NaseljenoMesto } from 'src/app/modeli/naseljeno-mesto';
import { Location } from '@angular/common';



@Component({
  selector: 'app-smestaj',
  templateUrl: './smestaj.component.html',
  styleUrls: ['./smestaj.component.css']
})
export class SmestajComponent implements OnInit {

@Input() SmestajShow : Smestaj; // sluzi za prikaz

  smestaji: Smestaj[];
  smestajId: string;
  smestajEdit: Smestaj;
  noviSmestaj: Smestaj = new Smestaj("", 0, null , "", "", null , null , null , null, null, null);

  constructor(private smestajService: SmestajService,
  private location: Location
  ) { }

  getSmestaji(): void {
    this.smestajService.getSmestaji()
      .subscribe(smestaji => this.smestaji = smestaji);
  }
  
    getSmestaj() {
      this.smestajService.getSmestaj(this.smestajId).subscribe(
        (smestaj) => this.smestajEdit = smestaj
      );
    }

    noviSmestajSubmit(forma: NgForm) {
      this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv; //dodati sve atribute za unos
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
      // this.noviSmestaj.naziv = forma.value.naziv;
     
      this.smestajService.insertSmestaj(this.noviSmestaj).subscribe();
      forma.reset();
      this.location.back();
    }

  ngOnInit() {
    this.getSmestaji();
    console.log(this.getSmestaji());
  }

  

}
