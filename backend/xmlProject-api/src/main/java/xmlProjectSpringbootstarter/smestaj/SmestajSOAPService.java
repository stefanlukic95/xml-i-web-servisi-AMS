package xmlProjectSpringbootstarter.smestaj;


import javax.jws.WebService;

@WebService
public interface SmestajSOAPService {

    Smestaj create(Smestaj smestaj);

}
