import { Component, OnInit } from '@angular/core';
import { TipsmestajaService } from '../../tipsmestaja.service';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { Tipsmestaja } from '../../modeli/tipsmestaja';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { NoviTipsmestaja } from '../../modeli/novi-tipsmestaja';

@Component({
  selector: 'app-tipsmestaja-edit',
  templateUrl: './tipsmestaja-edit.component.html',
  styleUrls: ['./tipsmestaja-edit.component.css']
})
export class TipsmestajaEditComponent implements OnInit {

  noviTipsmestaja: NoviTipsmestaja= new NoviTipsmestaja("");
  tipsmestajaId: string;
  tipsmestajaEdit: Tipsmestaja;
  tipovismestaja: Tipsmestaja[];

  constructor(private tipsmestajaService: TipsmestajaService,
              private location: Location,
              private route: ActivatedRoute) { }


              getTipsmestaja() {
                this.tipsmestajaService.getTipsmestaja(this.tipsmestajaId).subscribe(
                  (tipsmestaja) => this.tipsmestajaEdit = tipsmestaja
                );
              }

              

  ngOnInit() {

    if(this.route.snapshot.params['tipsmestajaId']){
      this.route.params.subscribe(
        (params: Params) => {
          this.tipsmestajaId = params["tipsmestajaId"];
        }
      );
      this.getTipsmestaja();
    }  
  }
  noviTipsmestajaSubmit(forma: NgForm) {
    this.noviTipsmestaja.naziv = forma.value.naziv;
   
    this.tipsmestajaService.insertTipSmestaja(this.noviTipsmestaja).subscribe();
    forma.reset();
    this.location.back();
  }



  tipsmestajaUpdtSubmit(forma: NgForm){
    this.tipsmestajaEdit.naziv = forma.value.naziv;
    this.tipsmestajaService.updateTipsmestaja(this.tipsmestajaEdit).subscribe();
    forma.reset();
    this.location.back();
  }

  tipsmestajaEdt() {
    this.tipsmestajaService.updateTipsmestaja(this.tipsmestajaEdit).subscribe();
    this.location.back();
  }

}
