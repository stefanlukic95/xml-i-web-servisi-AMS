package xmlProjectSpringbootstarter.korisnik;

public interface KorisnikService{
    Korisnik insert(Korisnik k);
    Korisnik findByEmail(String email);
}
