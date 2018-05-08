package xmlProjectSpringbootstarter.rezervacija;

import java.util.List;

public interface RezervacijaService {
    List<Rezervacija> findAll();
    Rezervacija findOne(String id);
    Rezervacija create(Rezervacija rezervacija) throws Exception;
    Rezervacija update(Rezervacija rezervacija) throws Exception;
    void delete(String id);
}
