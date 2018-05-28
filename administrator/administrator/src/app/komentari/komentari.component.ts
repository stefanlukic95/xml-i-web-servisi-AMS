import { Component, OnInit, Input} from '@angular/core';
import { KomentariService } from '../komentari.service';
import { Komentari } from '../modeli/komentari';

@Component({
  selector: 'app-komentari',
  templateUrl: './komentari.component.html',
  styleUrls: ['./komentari.component.css']
})
export class KomentariComponent implements OnInit {

  @Input() komentariShow: Komentari;
  komentari: Komentari[];
  komentarId: string;
  komentarEdit: Komentari;


  constructor(private komentariService: KomentariService) { }


  getKomentari(): void {
    this.komentariService.getKomentari()
      .subscribe(komentari => this.komentari = komentari);
  }
  
    getKomentar() {
      this.komentariService.getKomentar(this.komentarId).subscribe(
        (komentar) => this.komentarEdit = komentar
      );
    }


  ngOnInit() {
    this.getKomentari();
    console.log(this.komentari);

    
  }

}
