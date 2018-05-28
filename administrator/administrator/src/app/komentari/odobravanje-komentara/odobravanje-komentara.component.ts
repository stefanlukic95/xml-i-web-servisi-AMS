import { Component, OnInit , Input} from '@angular/core';
import { KomentariService } from '../../komentari.service';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { Komentari } from '../../modeli/komentari';


@Component({
  selector: 'app-odobravanje-komentara',
  templateUrl: './odobravanje-komentara.component.html',
  styleUrls: ['./odobravanje-komentara.component.css']
})
export class OdobravanjeKomentaraComponent implements OnInit {

  komentar: Komentari;
  komentarId: string;
  komentarEdit: Komentari;


  getKomentar() {
    this.komentariService.getKomentar(this.komentarId).subscribe(
      (komentar) => this.komentarEdit = komentar
    );
  }

  constructor(private komentariService: KomentariService,
    private location: Location,
    private route: ActivatedRoute) { }




  ngOnInit() {
    if(this.route.snapshot.params['komentarId']){
      this.route.params.subscribe(
        (params: Params) => {
          this.komentarId = params["komentarId"];
        }
      );
      this.getKomentar();
    }  

  }

}
