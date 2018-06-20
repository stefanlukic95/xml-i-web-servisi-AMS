package xmlProjectSpringbootstarter.rezervacija;

import javax.jws.WebService;

@WebService
public interface RezervacijaSOAPService {

    Rezervacija create(Rezervacija rezervacija);

}
