import { Component, OnInit } from '@angular/core';
import { Korisnikp } from '../modeli/korisnici-prikaz';
import { Router } from '@angular/router';
import { KorisniciService } from '../korisnici.service';
import { LoginService } from '../login.service';
import { AuthService } from '../login-core/auth.service';
import { TokenStorage } from '../login-core/token-storage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {};
  user: Korisnikp;
  loading = false;

  constructor(
    private router: Router,
    private authService: AuthService,
    private token: TokenStorage,
    private korisnikService: KorisniciService,
    private loginService: LoginService,
  ) {}

  ngOnInit() {}

  login(): void {
    this.loading = true;
    this.authService.attemptAuth(this.model.username, this.model.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        this.router.navigate(['komentari']);
       // this.toggleLoginService.toggle();
        window.location.reload();
      },
      error => {
       // this.alertService.error('Uneli ste neispravan email ili sifru');
        this.loading = false;
      }
    );

  }

}
