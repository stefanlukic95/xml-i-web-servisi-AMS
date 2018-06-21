package xmlProjectSpringbootstarter.drzava;

import smestaj.Drzava;

import javax.jws.WebService;

@WebService
public interface DrzavaSOAPService {

    smestaj.Drzava create(Drzava drz) ;
    Drzava findOne(String id);


}
