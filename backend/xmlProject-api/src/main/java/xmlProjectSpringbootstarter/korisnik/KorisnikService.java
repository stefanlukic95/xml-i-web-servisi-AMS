package xmlProjectSpringbootstarter.korisnik;

public interface KorisnikService{
    Korisnik findOne(String id);
    Korisnik insert(Korisnik k);
    Korisnik findByEmail(String email);
}
