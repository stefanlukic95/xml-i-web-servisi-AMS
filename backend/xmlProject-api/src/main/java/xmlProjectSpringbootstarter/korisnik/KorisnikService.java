package xmlProjectSpringbootstarter.korisnik;

public interface KorisnikService{
    Korisnik insert(Korisnik k);
    Korisnik findByEmail(String email);
    Korisnik create(Korisnik korisnik) throws Exception;
}
