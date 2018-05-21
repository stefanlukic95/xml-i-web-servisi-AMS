import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { KategorijaService } from '../kategorija.service';
import { Kategorija } from '../modeli/kategorija';
@Component({
  selector: 'app-kategorija',
  templateUrl: './kategorija.component.html',
  styleUrls: ['./kategorija.component.css']
})
export class KategorijaComponent implements OnInit {

  @Input() kategorijeShow: Kategorija;

  kategorije: Kategorija[];
  kategorijaId: string;
  kategorijaEdit: Kategorija;



  getKategorije(): void {
    this.kategorijaService.getKategorije()
      .subscribe(kategorije => this.kategorije = kategorije);
  }
  
    getKategorija() {
      this.kategorijaService.getKategorija(this.kategorijaId).subscribe(
        (kategorija) => this.kategorijaEdit = kategorija
      );
    }



  constructor(private kategorijaService: KategorijaService,
              private location: Location) { }

  ngOnInit() {
    this.getKategorije();
    console.log(this.kategorije)
  }

}
