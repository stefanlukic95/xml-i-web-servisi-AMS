package xmlProjectSpringbootstarter.dodatnaUsluga;

import javax.jws.WebService;

@WebService
public interface DodatnaUslugaSOAPService {

    DodatnaUsluga create(DodatnaUsluga dodatnaUsluga);
}
