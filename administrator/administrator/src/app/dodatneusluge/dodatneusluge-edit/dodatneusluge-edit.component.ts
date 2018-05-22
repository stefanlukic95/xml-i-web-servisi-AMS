import { Component, OnInit } from '@angular/core';

import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';

import { NgForm } from '@angular/forms/src/directives/ng_form';
import { NoveDodatneusluge } from '../../modeli/nove-dodatneusluge';
import { Dodatneusluge } from '../../modeli/dodatneusluge';
import { DodatneuslugeService } from '../../dodatneusluge.service';


@Component({
  selector: 'app-dodatneusluge-edit',
  templateUrl: './dodatneusluge-edit.component.html',
  styleUrls: ['./dodatneusluge-edit.component.css']
})
export class DodatneuslugeEditComponent implements OnInit {

  novaDodatnausluga: NoveDodatneusluge= new NoveDodatneusluge("");
  dodatnauslugaId: string;
  dodatnauslugaEdit: Dodatneusluge;
  dodatneusluge: Dodatneusluge[];

  constructor(private dodatneuslugeService: DodatneuslugeService,
              private location: Location,
              private route: ActivatedRoute) { }


              getDodatnausluga() {
                this.dodatneuslugeService.getDodatnausluga(this.dodatnauslugaId).subscribe(
                  (dodatnausluga) => this.dodatnauslugaEdit = dodatnausluga
                );
              }

              

  ngOnInit() {

    if(this.route.snapshot.params['dodatnauslugaId']){
      this.route.params.subscribe(
        (params: Params) => {
          this.dodatnauslugaId = params["dodatnauslugaId"];
        }
      );
      this.getDodatnausluga();
    }  
  }
  novaDodatnauslugaSubmit(forma: NgForm) {
    this.novaDodatnausluga.naziv = forma.value.naziv;
   
    this.dodatneuslugeService.insertDodatnausluga(this.novaDodatnausluga).subscribe();
    forma.reset();
    this.location.back();
  }



  dodatnauslugaUpdtSubmit(forma: NgForm){
    this.dodatnauslugaEdit.naziv = forma.value.naziv;
    this.dodatneuslugeService.updateDodatnausluga(this.dodatnauslugaEdit).subscribe();
    forma.reset();
    this.location.back();
  }

  dodatnauslugaEdt() {
    this.dodatneuslugeService.updateDodatnausluga(this.dodatnauslugaEdit).subscribe();
    this.location.back();
  }

}
