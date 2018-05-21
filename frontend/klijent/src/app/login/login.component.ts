import { KorisnikService } from './../korisnik/korisnik.service';
import { TokenStorage } from './../login-core/token-storage';
import { AuthService } from './../login-core/auth.service';
import { Router } from '@angular/router';
import { Korisnik } from './../korisnik/korisnik';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: any = {};
  user: Korisnik;
  loading = false;

  constructor(private router: Router, private authService: AuthService, private token: TokenStorage,
  private korisnikService: KorisnikService) {}

  ngOnInit() {}

  login(): void {
    this.authService.attemptAuth(this.model.username, this.model.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        this.router.navigate(['smestaj']);
        window.location.reload();
      }
    );

  }
}
