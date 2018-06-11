package xmlProjectSpringbootstarter.smestaj;


import javax.jws.WebService;

@WebService //(targetNamespace="http://xmlProjectSpringbootstarter/", name="SmestajService")
public interface SmestajSOAPService {

    Smestaj create(Smestaj smestaj);

}
