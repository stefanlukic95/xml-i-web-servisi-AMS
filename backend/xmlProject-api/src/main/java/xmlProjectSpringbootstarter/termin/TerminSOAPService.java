package xmlProjectSpringbootstarter.termin;

import javax.jws.WebService;

@WebService
public interface TerminSOAPService {

    Termin create(Termin termin);
}
