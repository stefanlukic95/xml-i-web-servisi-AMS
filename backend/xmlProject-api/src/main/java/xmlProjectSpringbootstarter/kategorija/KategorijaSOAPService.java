package xmlProjectSpringbootstarter.kategorija;

import javax.jws.WebService;

@WebService
public interface KategorijaSOAPService {

    Kategorija create(Kategorija kategorija);
}
