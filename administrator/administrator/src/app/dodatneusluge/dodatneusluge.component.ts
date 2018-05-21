import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { Dodatneusluge } from '../modeli/dodatneusluge';
import { DodatneuslugeService } from '../dodatneusluge.service';
@Component({
  selector: 'app-dodatneusluge',
  templateUrl: './dodatneusluge.component.html',
  styleUrls: ['./dodatneusluge.component.css']
})
export class DodatneuslugeComponent implements OnInit {


  @Input() dodatneuslugeShow: Dodatneusluge;

  dodatneusluge: Dodatneusluge[];
  dodatnauslugaId: string;
  dodatneuslugeEdit: Dodatneusluge;


  getDodatneusluge(): void {
    this.dodatneuslugeService.getDodatneusluge()
      .subscribe(dodatneusluge => this.dodatneusluge = dodatneusluge);
  }
  
    getDodatnausluga() {
      this.dodatneuslugeService.getDodatnausluga(this.dodatnauslugaId).subscribe(
        (dodatnausluga) => this.dodatneuslugeEdit = dodatnausluga
      );
    }



  constructor(private dodatneuslugeService: DodatneuslugeService,
              private location: Location) { }

  ngOnInit() {
    this.getDodatneusluge();
    console.log(this.dodatneusluge);
  }

}
