import { Component, OnInit, Input } from '@angular/core';
import { TipsmestajaService } from '../tipsmestaja.service';
import { ActivatedRoute } from '@angular/router';
import { Tipsmestaja } from '../modeli/tipsmestaja';
import { Location } from '@angular/common';

@Component({
  selector: 'app-tipsmestaja',
  templateUrl: './tipsmestaja.component.html',
  styleUrls: ['./tipsmestaja.component.css']
})
export class TipsmestajaComponent implements OnInit {

  @Input() tipovismestajaShow: Tipsmestaja;

  tipovismestaja: Tipsmestaja[];
  tipsmestajaId: string;
  tipsmestajaEdit: Tipsmestaja;



  getTipovismestaja(): void {
    this.tipsmestajaService.getTipovismestaja()
      .subscribe(tipovismestaja => this.tipovismestaja = tipovismestaja);
  }
  
    getTipsmestaja() {
      this.tipsmestajaService.getTipsmestaja(this.tipsmestajaId).subscribe(
        (tipsmestaja) => this.tipsmestajaEdit = tipsmestaja
      );
    }

  constructor(private tipsmestajaService: TipsmestajaService,
              private location: Location,
              private route: ActivatedRoute
              ) { }

  ngOnInit() {
    this.getTipovismestaja();
    console.log(this.tipovismestaja);
  }

}
