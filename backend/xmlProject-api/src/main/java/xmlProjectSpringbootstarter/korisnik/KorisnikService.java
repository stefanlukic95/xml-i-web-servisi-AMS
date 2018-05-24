package xmlProjectSpringbootstarter.korisnik;

import java.util.List;

public interface KorisnikService{
    Korisnik findOne(String id);
    Korisnik insert(Korisnik k);
    Korisnik findByEmail(String email);
    Korisnik create(Korisnik korisnik) throws Exception;
}
