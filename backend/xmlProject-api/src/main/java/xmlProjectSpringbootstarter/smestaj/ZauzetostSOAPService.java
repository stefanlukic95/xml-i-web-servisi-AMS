package xmlProjectSpringbootstarter.smestaj;

import javax.jws.WebService;

@WebService
public interface ZauzetostSOAPService {

    Zauzetost create(Zauzetost zauzetost);
}
